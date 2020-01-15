package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_ImplicitConstraints extends App {

    trait Food { def name: String }

    case class Fruit(name: String) extends Food
    case class Cereal(name: String) extends Food
    case class Meat(name: String) extends Food

    trait Eater { def name: String }

    case class Vegan(name: String) extends Eater
    case class Vegetarian(name: String) extends Eater
    case class Paleo(name: String) extends Eater

    trait Eats[EATER <: Eater, FOOD <: Food] {
        def feed(food: FOOD, eater: EATER) = println(s"${eater.name} eats ${food.name}")
    }

    def feedTo[FOOD <: Food, EATER <: Eater](food: FOOD, eater: EATER)(implicit ev: Eats[EATER, FOOD]) = {
        ev.feed(food, eater)
    }

    val apple = Fruit("Apple")
    val alpen = Cereal("Alpen")
    val beef = Meat("Beef")

    val alice = Vegan("Alice")
    val bob = Vegetarian("Bob")
    val charlie = Paleo("Charlie")

    object VeganRules {
        implicit object VeganEatsFruit extends Eats[Vegan, Fruit]
    }

    import VeganRules._

    feedTo(apple, alice)

    object VegetarianRules {
        implicit object VegEatsFruit extends (Vegetarian Eats Fruit)
        implicit object VegEatsCereal extends (Vegetarian Eats Cereal)
    }

    object PaleoRules {
        implicit val PaleoEatsFruit = new (Paleo Eats Fruit) {}
        implicit val PaleoEatsMeat = new (Paleo Eats Meat) {}
    }

    import VegetarianRules._
    import PaleoRules._

    feedTo(apple, bob)
    feedTo(alpen, bob)
//    feedTo(beef, bob)

    feedTo(apple, charlie)
//    feedTo(alpen, charlie)
    feedTo(beef, charlie)

}
