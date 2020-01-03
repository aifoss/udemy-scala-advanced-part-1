package com.learning.scala.moduels.module01.properties_and_state

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_StateCanBleed extends App {

    class Person(val name: String, var weight: Double) {
        override def toString: String = s"Person($name, $weight)"
    }

    val alice = new Person("Alice", 123)
    val bob = new Person("Bob", 124)

    val all = Seq(alice, bob)

    println(all)

    def heaviestPerson(people: Seq[Person]): Person =
        people.maxBy(_.weight)

    println("Heaviest: " + heaviestPerson(all))

    bob.weight = 122

    println()
    println(all)

    println("Heaviest: " + heaviestPerson(all))

}
