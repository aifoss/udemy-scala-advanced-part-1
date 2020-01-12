package com.learning.scala.moduels.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_Variance extends App {

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

    case class FoodBowl[F <: Food](contents: F) {
        override def toString: String = s"A yummy food bowl of ${contents.name}s"
    }

    // invariance

    def serveToFruitEater(fruitBowl: FoodBowl[Fruit]): Unit =
        println(s"[serveToFruitEater(fruitBowl: FoodBowl[Fruit])] mmm, those ${fruitBowl.contents.name}s were very good")

    val fruitBowl = FoodBowl[Fruit](fuji)
    val cerealBowl = FoodBowl[Cereal](alpen)

    serveToFruitEater(fruitBowl)
    println()

    def serveToFoodEater(foodBowl: FoodBowl[Food]): Unit =
        println(s"[serveToFoodEater(foodBowl: FoodBowl[Food])] mmm, I really liked that ${foodBowl.contents.name}")

    val foodBowl1 = FoodBowl[Food](fuji)
    val foodBowl2 = FoodBowl[Food](alpen)

    serveToFoodEater(foodBowl1)
    serveToFoodEater(foodBowl2)
    println()

    // covariance

    case class FoodBowl2[+F <: Food](contents: F) {
        override def toString: String = s"a yummy bowl of ${contents.name}"
    }

    def serveToFoodEater(foodBowl: FoodBowl2[Food]): Unit =
        println(s"[serveToFoodEater(foodBowl: FoodBowl2[Food])] mmm, I really liked bowl of ${foodBowl.contents.name}s")

    serveToFoodEater(FoodBowl2[Fruit](fuji))
    serveToFoodEater(FoodBowl2[Cereal](alpen))
    println()

    def serveToFruitEater(foodBowl: FoodBowl2[Fruit]): Unit =
        println(s"[serveToFruitEater(foodBowl: FoodBowl2[Fruit])] Nice fruity ${foodBowl.contents.name}s")

    serveToFruitEater(FoodBowl2[Apple](fuji))
    serveToFruitEater(FoodBowl2(fuji))

}
