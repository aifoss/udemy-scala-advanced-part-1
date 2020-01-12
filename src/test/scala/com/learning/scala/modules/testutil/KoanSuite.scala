package com.learning.scala.modules.testutil

import org.scalatest.FunSuite

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
abstract class KoanSuite extends FunSuite with StopOnFirstFailure {
    def koan(name: String)(fun: => Unit): Unit = test(name)(fun)
}
