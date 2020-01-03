package com.learning.scala.moduels.module01.properties_and_state

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_BehindTheScenes extends App {

    val KilosToPounds = 2.20462262185

    class Person(nm: String, wt: Double) {

        def name: String = nm

        private[this] var weight = wt

        def weightInPounds: Double = weight

        def weightInPounds_=(newWeight: Double): Unit = {
            weight = newWeight
        }

        def weightInKilos: Double = weight / KilosToPounds

        def weightInKilos_=(newWeight: Double): Unit = {
            weight = newWeight * KilosToPounds
        }

        def printWeight(): Unit = {
            println("Weight in Pounds: " + weightInPounds)
            println("Weight in Kilos : " + weightInKilos)
            println()
        }
    }

    val fred = new Person("Fred", 120)

    fred.printWeight()

    fred.weightInKilos_=(60)
    fred.printWeight()

    fred.weightInPounds_=(125)
    fred.printWeight()

}
