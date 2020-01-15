package com.learning.scala.modules.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_TypeParamsRecap extends App {

    trait Food { val name: String }
    trait Fruit extends Food
    trait Cereal extends Food

    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit
    case class Muesli(name: String) extends Cereal

    case class FoodBowl[+F <: Food](food: F) {
        def eat: String = s"Yummy ${food.name}"
    }

    val fiji = Apple("fiji")
    val jaffa = Orange("jaffa")
    val alpen = Muesli("alpen")

    val bowlOfAlpen = FoodBowl(alpen)

    bowlOfAlpen.eat

    val foodInBowl1 = bowlOfAlpen.food

    println(s"foodInBowl1: $foodInBowl1")

    val foodInBowl2: Muesli = bowlOfAlpen.food

    println(s"foodInBowl2: $foodInBowl2")

    // but this doesn't work - try it:
    // val foodInBowl: bowlOfAlpen.F = bowlOfAlpen.food

}
