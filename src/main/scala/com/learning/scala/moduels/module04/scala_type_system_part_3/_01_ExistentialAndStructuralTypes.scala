package com.learning.scala.moduels.module04.scala_type_system_part_3

import language.existentials
import language.reflectiveCalls

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_ExistentialAndStructuralTypes extends App {

    // Existential Types

    def lengthOfList(xs: List[T forSome {type T}]): Int = xs.length

    def lengthOfList2(xs: List[_]): Int = xs.length

    trait Food { val name: String }
    trait Fruit extends Food

    case class Apple(name: String) extends Fruit

    val fruits = List(Apple("Fiji"), Apple("Granny Smith"))

    def fruitNames[T <: Fruit](fruits: List[T]) = fruits.map(_.name)
    def fruitNames2(fruits: List[T forSome {type T <: Fruit}]) = fruits.map(_.name)
    def fruitNames3(fruits: List[_ <: Fruit]) = fruits.map(_.name)

    println(fruitNames(fruits))
    println(fruitNames2(fruits))
    println(fruitNames3(fruits))

    // Structural Types

    def maxSizeInSeq(xs: Seq[_ <: {def size: Int}]): Int = xs.map(_.size).max

    case class Person(name: String, age: Int) {
        def size: Int = name.length
    }

    println(maxSizeInSeq(Seq(
        List(1,2,3),
        List(4,5),
        List(6,7,8,9),
        List(10)
    )))

    println(maxSizeInSeq(Seq(
        Person("Harry", 20),
        Person("Fred", 21)
    )))

    val s: String = "hello"
    val as: Any = "hello"

    s.charAt(1)
    // This will not compile, because scala can't type check it
    // as.charAt(1)

    as.asInstanceOf[{def charAt(x: Int): Char}].charAt(1)

}
