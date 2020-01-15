package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _07_ImplicitValueClasses extends App {

    implicit class TimesInt(val i: Int) extends AnyVal {
        def times(fn: => Unit): Unit = {
            var x = 0
            while (x < i) {
                x += 1
                fn
            }
        }
    }

    5 times { println("hello") }

}
