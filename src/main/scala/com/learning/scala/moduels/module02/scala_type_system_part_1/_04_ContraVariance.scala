package com.learning.scala.moduels.module02.scala_type_system_part_1

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _04_ContraVariance extends App {

    trait Food {
        val name: String
        override def toString: String = s"Yummy $name"
    }

    trait Fruit extends Food

    case class Apple(name: String) extends Fruit
    case class Orange(name: String) extends Fruit

    trait Sink[T] {
        def send(item: T): String
    }

    object AnySink extends Sink[Any] {
        def send(item: Any) = s"Sending ${item.toString}"
    }
    object FruitSink extends Sink[Fruit] {
        def send(item: Fruit) = s"Eating a healthy ${item.name}"
    }
    object AppleSink extends Sink[Apple] {
        def send(item: Apple) = s"Coloring and eating ${item.name}"
    }
    object OrangeSink extends Sink[Orange] {
        def send(item: Orange) = s"Juicing and drinking ${item.name}"
    }

    def sinkAnApple(sink: Sink[Apple]): Unit = {
        println(sink.send(Apple("Fuji")))
    }

    sinkAnApple(AppleSink)

    // these do not work
//    sinkAnApple(OrangeSink)
//    sinkAnApple(FruitSink)
//    sinkAnApple(AnySink)

    // contra-variance

    trait Sink2[-T] {
        def send(item: T): String
    }

    object AnySink2 extends Sink2[Any] {
        def send(item: Any) = s"Sending ${item.toString}"
    }
    object FruitSink2 extends Sink2[Fruit] {
        def send(item: Fruit) = s"Eating a healthy ${item.name}"
    }
    object AppleSink2 extends Sink2[Apple] {
        def send(item: Apple) = s"Coloring and eating ${item.name}"
    }
    object OrangeSink2 extends Sink2[Orange] {
        def send(item: Orange) = s"Juicing and drinking ${item.name}"
    }

    def sinkAnApple(sink: Sink2[Apple]): Unit = {
        println(sink.send(Apple("Fuji")))
    }

    sinkAnApple(AppleSink2)
//    sinkAnApple(OrangeSink2) // should not work
    sinkAnApple(FruitSink2)
    sinkAnApple(AnySink2)

}
