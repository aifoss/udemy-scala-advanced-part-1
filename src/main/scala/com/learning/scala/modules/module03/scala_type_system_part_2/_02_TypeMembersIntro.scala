package com.learning.scala.modules.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_TypeMembersIntro extends App {

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

    val appleBowl = new AppleBowl(Apple("Fiji"))

    val apple1 = appleBowl.food
    val apple2: Apple = appleBowl.food
    val apple3: appleBowl.FOOD = appleBowl.food
    val apple4: AppleBowl#FOOD = appleBowl.food

    println("appleBowl.food:")
    println(apple1)
    println(apple2)
    println(apple3)
    println(apple4)

}
