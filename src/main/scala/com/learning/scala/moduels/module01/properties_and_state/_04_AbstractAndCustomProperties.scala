package com.learning.scala.moduels.module01.properties_and_state

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _04_AbstractAndCustomProperties extends App {

    trait HeightAndWeight {

        var height: Double
        var weight: Double

        def printHeightAndWeight(): Unit = {
            println("Height: " + height)
            println("Weight: " + weight)
            println()
        }

    }

    trait HeightAndWeightAsGenerated {

        def height: Double
        def height_=(d: Double): Unit

        def weight: Double
        def weight_=(d: Double): Unit

    }

    class Person(val name: String) extends HeightAndWeight {

        private[this] var ht: Double = _
        private[this] var wt: Double = _

        def height: Double = ht
        def height_=(h: Double): Unit = {
            require(h > 0.0, "Height may not be zero or negative")
            ht = h
        }

        def weight: Double = wt
        def weight_=(w: Double): Unit = {
            require(w > 0.0, "Weight may not be zero or negative")
            wt = w
        }

    }

    val fred = new Person("Fred")

    fred.printHeightAndWeight()

    fred.height = 172.0
    fred.printHeightAndWeight()

    fred.weight = 65.0
    fred.printHeightAndWeight()

    class TruckLOad extends HeightAndWeight {

        import scala.collection.mutable

        private[this] val propMap = mutable.Map.empty[String, Double]

        def height: Double = propMap.getOrElse("height", 0.0)
        def height_=(h: Double): Unit = propMap("height") = h

        def weight: Double = propMap.getOrElse("weight", 0.0)
        def weight_=(w: Double): Unit = propMap("weight") = w

    }

    val truck = new TruckLOad

    truck.printHeightAndWeight()

    truck.height = 20.0
    truck.printHeightAndWeight()

    truck.weight = 30.0
    truck.printHeightAndWeight()

}
