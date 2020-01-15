package com.learning.scala.modules.module04.scala_type_system_part_3

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_Enumerations extends App {

    object Color extends Enumeration {
        val Red, Green, Yellow, Blue = Value
    }

    object Size extends Enumeration {
        val S = Value(1, "Small")
        val M = Value(2, "Medium")
        val L = Value(3, "Large")
        val XL = Value(4, "Extra Large")
    }

    println(Color.values)
    println(Size.values)

    println(Color.Green.id)
    println(Size.S.id)

    println(Color.apply(2))
    println(Size.withName("Large"))

    def shirt(color: Color.Value, size: Size.Value): String =
        s"A nice hawaiian shirt, color $color, size $size"

    println(shirt(color = Color.Red, size = Size.XL))

}
