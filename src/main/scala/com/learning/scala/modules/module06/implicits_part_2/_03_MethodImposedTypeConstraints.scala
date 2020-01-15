package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_MethodImposedTypeConstraints extends App {

    case class Cell[T](item: T) {
        def *[U: Numeric](other: Cell[U])(implicit ev: T =:= U): Cell[U] = {
            val numClass = implicitly[Numeric[U]]
            Cell(numClass.times(this.item, other.item))
        }
    }

    val stringCell = Cell("hello")
    val intCell = Cell(6)

    println(intCell * Cell(7))

//    stringCell * Cell("world")

}
