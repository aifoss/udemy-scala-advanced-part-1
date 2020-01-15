package com.learning.scala.modules.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_UpperBounds extends App {

    abstract class Food { val name: String }

    abstract class Fruit extends Food

    case class Banana(name: String) extends Fruit
    case class Apple(name: String) extends Fruit

    abstract class Cereal extends Food

    case class Granola(name: String) extends Cereal
    case class Muesli(name: String) extends Cereal

    def eat(f: Food): Unit = println(s"${f.name} eaten")

    val fuji = Apple("Fuji")
    val alpen = Muesli("Alpen")

    case class Bowl[F](contents: F) {
        override def toString: String = s"A yummy bowl of ${contents}s"
    }

    abstract class Animal {
        val name: String
        override def toString: String = s"Animal-$name"
    }

    case class Dog(name: String) extends Animal

    val dottie = Dog("Dottie")

    val dogBowl: Bowl[Dog] = Bowl(dottie)

    println(dogBowl)

    case class FoodBowl[F <: Food](contents: F) {
        override def toString: String = s"A yummy food bowl of ${contents.name}s"
    }

    val appleBowl: FoodBowl[Apple] = FoodBowl(fuji)

    println(appleBowl)

}
