package com.learning.scala.modules.module05.implicits_part_1

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_TypeClassComposition extends App {

    trait JSONWrite[T] {
        def toJsonString(item: T): String
    }

    def jsonify[T: JSONWrite](item: T): String =
        implicitly[JSONWrite[T]].toJsonString(item)

    implicit object StrJSONWrite extends JSONWrite[String] {
        override def toJsonString(item: String): String = s"""$item"""
    }

    implicit object IntJSONWrite extends JSONWrite[Int] {
        override def toJsonString(item: Int): String = item.toString
    }

    implicit object DoubleJSONWrite extends JSONWrite[Double] {
        override def toJsonString(item: Double): String = item.toString
    }

    implicit object BooleanJSONWrite extends JSONWrite[Boolean] {
        override def toJsonString(item: Boolean): String = item.toString
    }

    implicit def listJSONWrite[T: JSONWrite] = new JSONWrite[List[T]] {
        override def toJsonString(item: List[T]): String = {
//            val tJsonify = implicitly[JSONWrite[T]]
//            item.map(x => tJsonify.toJsonString(x)).mkString("[", ", ", "]")
            item.map(x => jsonify(x)).mkString("[", ", ", "]")
        }
    }

    println(jsonify("Hello"))
    println(jsonify(1.0))
    println(jsonify(List("Hello", "World")))
    println(jsonify(List(1, 2, 3)))
    println(jsonify(List(1.0, 2.0, 3.0)))
    println(jsonify(List(true, false, true)))

    implicit def mapJSONWrite[T: JSONWrite] = new JSONWrite[Map[String, T]] {
        override def toJsonString(item: Map[String, T]): String = {
            val pairs =
                for ((k, v) <- item)
                    yield s"${jsonify(k)}: ${jsonify(v)}"
            pairs.mkString("{\n  ", ",\n  ", "\n}")
        }
    }

    println(jsonify(Map(
        "hello" -> List("hello", "world"),
        "goodbye" -> List("goodbye", "cruel", "world")
    )))

}
