package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _06_ExtensionMethods extends App {

    implicit class TimesInt(i: Int) {
        def times(fn: => Unit): Unit = {
            var x = 0
            while (x < i) {
                x += 1
                fn
            }
        }
    }

//    implicit def intToTimesInt(i: Int): TimesInt = new TimesInt(i)

    5 times { println("hello") }

//    intToTimesInt(5).times { println("hello") }

    // to disable an implicit in the same scope
//    import scala.language.implicitConversions
//
//    def intToTimesInt(i: Int) = ???

}
