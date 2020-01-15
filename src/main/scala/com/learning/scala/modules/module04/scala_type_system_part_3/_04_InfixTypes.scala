package com.learning.scala.modules.module04.scala_type_system_part_3

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _04_InfixTypes extends App {

    val s = "hello"

    s.charAt(1)
    s charAt 1

    case class Person(name: String)

    class Loves[T1, T2] {
        def describe(i1: T1, i2: T2) = s"$i1 loves $i2"
    }

    case class NamedLoves(p1: String, p2: String) extends Loves[String, String] {
        def sayIt: String = describe(p1, p2)
    }

    case class PersonLoves(p1: Person, p2: Person) extends (Person Loves Person) {
        def sayIt: String = describe(p1, p2)
    }

    def sayItWithRoses(lovers: Person Loves Person) =
        s"Roses are red, violets are blue, I love you so much, I made you both stew, $lovers"

    println(sayItWithRoses(PersonLoves(Person("Harry"), Person("Sally"))))

}
