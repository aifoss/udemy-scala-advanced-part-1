package com.learning.scala.moduels.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_Generics extends App {

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

    eat(fuji)
    eat(alpen)

    case class Bowl(food: Food) {
        def contents: Food = food
        override def toString = s"A bowl of yummy ${food.name}"
    }

    val fruitBowl: Bowl = Bowl(fuji)
    val cerealBowl: Bowl = Bowl(alpen)

    println(fruitBowl)
    println(cerealBowl)

    val fruitBowlContents: Food = fruitBowl.contents
    val cerealBowlContents: Food = cerealBowl.contents

    println(fruitBowlContents)
    println(cerealBowlContents)

    // generics
    case class Bowl2[F](contents: F) {
        override def toString: String = s"A yummy bowl of ${contents}s"
    }

    val appleBowl: Bowl2[Apple] = Bowl2(fuji)
    val muesliBowl: Bowl2[Muesli] = Bowl2(alpen)

    println(appleBowl)
    println(muesliBowl)

    val appleBowlContents: Apple = appleBowl.contents
    val muesliBowlContents: Muesli = muesliBowl.contents

    println(appleBowlContents)
    println(muesliBowlContents)

}
