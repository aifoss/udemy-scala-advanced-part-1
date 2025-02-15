package com.learning.scala.modules.module04.scala_type_system_part_3

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_RefinementTypes extends App {

    trait Food { val name: String }
    trait Fruit extends Food
    trait Cereal extends Food

    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit
    case class Muesli(name: String) extends Cereal

    val fiji = Apple("Fiji")
    val alpen = Muesli("Alpen")

    case class FoodBowlT[+F <: Food](item: F)

    val appleBowl = FoodBowlT[Apple](fiji)
    val muesliBowl = FoodBowlT[Muesli](alpen)

    def feedToFruitEater(bowl: FoodBowlT[Fruit]): Unit =
        println(s"Yummy ${bowl.item.name}")

    feedToFruitEater(appleBowl)

    // type mismatch
    // feedToFruitEater(muesliBowl)

    abstract class FoodBowl {
        type FOOD <: Food
        val item: FOOD
    }

    class AppleBowl extends FoodBowl {
        type FOOD = Apple
        val item = fiji
    }

    class MuesliBowl extends FoodBowl {
        type FOOD = Muesli
        val item = alpen
    }

    def feedToFruitEater(bowl: FoodBowl): Unit =
        println(s"yummy ${bowl.item.name}")

    feedToFruitEater(new AppleBowl)
    feedToFruitEater(new MuesliBowl) // this shouldn't have worked

    def safeFeedToFruitEater(bowl: FoodBowl{ type FOOD <: Fruit }): Unit =
        println(s"yummy ${bowl.item.name}")

    safeFeedToFruitEater(new AppleBowl)
    // type mismatch
    // safeFeedToFruitEater(new MuesliBowl)

}
