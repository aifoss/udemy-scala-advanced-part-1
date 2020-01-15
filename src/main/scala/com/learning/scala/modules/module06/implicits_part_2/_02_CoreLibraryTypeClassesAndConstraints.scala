package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_CoreLibraryTypeClassesAndConstraints extends App {

    val intNumT = implicitly[Numeric[Int]]

    println(intNumT.times(5, 8))

    val doubleNumT = implicitly[Numeric[Double]]

    println(doubleNumT.times(5.0, 8.0))

}
