package com.learning.scala.moduels.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _04_UsingParametersWithMembers extends App {

    trait Food { val name: String }
    trait Fruit extends Food
    trait Cereal extends Food

    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit
    case class Muesli(name: String) extends Cereal

    abstract class FoodBowl2 {
        type FOOD <: Food
        val food: FOOD
        def eat: String = s"Yummy ${food.name}"
    }

    class AppleBowl(val food: Apple) extends FoodBowl2 {
        type FOOD = Apple
    }

    object BowlOfFood {
        def apply[F <: Food](f: F) = new FoodBowl2 {
            type FOOD = F
            override val food: FOOD = f
        }
    }

    val bowlOfAlpen = BowlOfFood(Muesli("alpen"))

    println(s"bowlOfAlpen food: ${bowlOfAlpen.food}")

    val appleBowl = BowlOfFood(Apple("fiji"))
    val orangeBowl = BowlOfFood(Orange("jaffa"))

    val a1: Apple = appleBowl.food
    val a2: appleBowl.FOOD = appleBowl.food

    println(a1)
    println(a2)

    // but does not compile:
    // val o1: orangeBowl.FOOD = appleBowl.food

}
