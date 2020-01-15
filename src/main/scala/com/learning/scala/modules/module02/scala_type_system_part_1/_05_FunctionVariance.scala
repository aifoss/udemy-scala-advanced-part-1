package com.learning.scala.modules.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_FunctionVariance extends App {

    abstract class Food { val name: String }

    abstract class Fruit extends Food

    case class Banana(name: String) extends Fruit
    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit

    abstract class Cereal extends Food

    case class Granola(name: String) extends Cereal
    case class Muesli(name: String) extends Cereal

    trait Description {
        val desc: String
    }

    case class Taste(desc: String) extends Description
    case class Texture(desc: String) extends Description

    def describeAnApple(fn: Apple => Description): Description =
        fn(Apple("Fuji"))

    val getJuicyFruitDesc: Fruit => Taste =
        fruit => Taste(s"This ${fruit.name} is nice and juicy")
    val getBumpyOrangeDesc: Orange => Texture =
        orange => Texture(s"This ${orange.name} is bumpy")

    println(describeAnApple(getJuicyFruitDesc))

    def describeAFruit(fn: Fruit => Description): Description =
        fn(Apple("Fuji"))

    println(describeAFruit(getJuicyFruitDesc))

}
