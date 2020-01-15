package com.learning.scala.modules.module05.implicits_part_1

import scala.reflect.runtime.universe._

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_TypeTagInAGuard extends App {

    implicit val tt = typeTag[Map[Int, String]]

    case class Tagged[T](value: T)(implicit val tag: TypeTag[T])

    val taggedMap1 = Tagged(Map(1 -> "one", 2 -> "two"))
    val taggedMap2 = Tagged(Map(1 -> 1, 2 -> 2))

    def taggedIsA[A, B](x: Tagged[Map[A, B]]): Boolean = x.tag.tpe match {
        case t if t == typeOf[Map[Int, String]] => true
        case _ => false
    }

    println(taggedIsA(taggedMap1))
    println(taggedIsA(taggedMap2))

}
