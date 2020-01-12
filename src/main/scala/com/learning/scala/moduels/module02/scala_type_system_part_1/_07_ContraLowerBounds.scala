package com.learning.scala.moduels.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _07_ContraLowerBounds extends App {

    trait Food {
        val name: String
        override def toString = s"Yummy $name"
    }

    trait Fruit extends Food

    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit

    trait Sink[-T] { outer =>
        def send(item: T): String

        def andThenSink[U <: T](other: Sink[U]): Sink[U] = {
            item => outer.send(item) + " and then " + other.send(item)
        }
    }

    object AppleSink extends Sink[Apple] {
        def send(item: Apple) = s"Coring and eating ${item.name}"
    }
    object OrangeSink extends Sink[Orange] {
        def send(item: Orange) = s"Juicing and drinking ${item.name}"
    }
    object FruitSink extends Sink[Fruit] {
        def send(item: Fruit) = s"Eating a healthy ${item.name}"
    }
    object AnySink extends Sink[Any] {
        def send(item: Any) = s"Sending ${item.toString}"
    }

    def sinkAnApple(sink: Sink[Apple]): String = {
        sink.send(Apple("Fuji"))
    }

    println(sinkAnApple(AppleSink))

    val newSink1: Sink[Apple] = FruitSink.andThenSink(AppleSink)

    println(sinkAnApple(newSink1))

    val newSink2: Sink[Apple] = AppleSink.andThenSink(FruitSink)

    println(sinkAnApple(newSink2))

//    val newSink3: Sink[Fruit] = FruitSink.andThenSink(AppleSink)
//    val newSink4: Sink[Fruit] = AppleSink.andThenSink(FruitSink)

}
