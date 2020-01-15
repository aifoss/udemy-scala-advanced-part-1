package com.learning.scala.moduels.module05.implicits_part_1

import scala.reflect._
import scala.reflect.runtime.universe._

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _04_ClassTags extends App {

    val s: String = "hello"

    val stringClass: Class[String] = classOf[String]

    val stringClassTag = classTag[String]

    println(classOf[String])
    println(stringClassTag)

    def getClassTag[T: ClassTag](X: T): ClassTag[T] = classTag[T]

    val intCT = getClassTag(10)

    println(intCT)
    println(intCT.runtimeClass)

    val strCT = getClassTag("hello")

    println(strCT)
    println(strCT.runtimeClass)

    val intArr = intCT.newArray(5)

    println(intArr(0))


    // ClassTags in Pattern Matches

    def isA[T: ClassTag](x: Any): Boolean = x match {
        case _: T => true
        case _ => false
    }

    println(isA[Int](7))
    println(isA[Int]("Hello"))


    // ClassTag vs TypeTag

    // ClassTag only provides class tagging for the top type
    isA[Map[String, Int]](Map("hello" -> 2)) // true
    isA[Map[String, Int]](Map("hello" -> "foo")) // also true

    // TypeTag provides everything compiler knows about the type
    val ct = classTag[Map[String, List[Int]]]
    val tt = typeTag[Map[String, List[Int]]]

    println(ct)
    println(tt)

    val theType = tt.tpe

    println(theType)
    println(theType.baseClasses)
    println(theType.typeArgs)

}
