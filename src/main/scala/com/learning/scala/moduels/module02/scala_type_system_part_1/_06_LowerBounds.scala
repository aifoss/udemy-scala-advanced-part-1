package com.learning.scala.moduels.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _06_LowerBounds extends App {

    abstract class Food extends Product with Serializable { val name: String }

    abstract class Fruit extends Food
    case class Banana(name: String) extends Fruit
    case class Apple(name: String) extends Fruit

    abstract class Cereal extends Food
    case class Granola(name: String) extends Cereal
    case class Muesli(name: String) extends Cereal

    val fuji = Apple("Fuji")
    val alpen = Muesli("Alpen")

    trait CombineWith[T] {
        val item: T
        def combineWith(another: T): T
    }

    case class CombineWithInt(item: Int) extends CombineWith[Int] {
        override def combineWith(another: Int): Int = item + another
    }

    val cwi: CombineWith[Int] = CombineWithInt(10)

    // invariant behavior

//    val cwa: CombineWith[Any] = CombineWithInt(10)
//    cwa.combineWith("ten")
//
//    trait CombineWith2[+T] {
//        val item: T
//        def combineWith(another: T): T
//    }

    val ints = List(1,2,3,4)
    val anyVals = true :: ints
    val anys = "hello" :: anyVals

    case class MixedFoodBowl[+F <: Food](food1: F, food2: F) {
        override def toString: String = s"${food1.name} mixed with ${food2.name}"
    }

    case class FoodBowl[+F <: Food](food: F) {
        def mix[M >: F <: Food](other: M): MixedFoodBowl[M] =
            MixedFoodBowl[M](food, other)

        override def toString: String = s"A bowl of ${food.name}"
    }

    val apple = Apple("Fuji")
    val banana = Banana("Chiquita")

    val m1 : MixedFoodBowl[Fruit] = FoodBowl(banana).mix(apple)
    val m2 : MixedFoodBowl[Food] = FoodBowl(apple).mix(alpen)

    println(m1)
    println(m2)

}
