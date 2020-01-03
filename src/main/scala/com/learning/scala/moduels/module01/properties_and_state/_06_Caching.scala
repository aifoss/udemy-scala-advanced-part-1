package com.learning.scala.moduels.module01.properties_and_state

import com.google.common.cache.{CacheLoader, CacheBuilder}
import scala.concurrent._
import duration._
import ExecutionContext.Implicits.global

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _06_Caching extends App {

    object FakeWeatherLookup {

        private val cache = CacheBuilder.newBuilder()
            .build {
                new CacheLoader[String, Future[Double]] {
                    def load(key: String) = Future(fakeWeatherLookup(key))
                }
            }

        def apply(wxCode: String): Future[Double] = cache.get(wxCode)

    }

    def fakeWeatherLookup(wxCode: String): Double = {
        Thread.sleep(1000)
        wxCode.toList.map(_.toInt).sum / 10.0
    }

    val f1: Future[Double] = FakeWeatherLookup("SFO")
    val f2: Future[Double] = FakeWeatherLookup("SFO")

    Await.result(f1, 3.seconds)
    Await.result(f2, 3.seconds)

    println(f1)
    println(f2)

}
