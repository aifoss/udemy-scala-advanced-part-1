package com.learning.scala.moduels.module01.properties_and_state

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_Modifiers extends App {

    val KilosToPounds = 2.20462262185

    class Person(val name: String, var weightInPounds: Double) {

        def weightInKilos: Double = weightInPounds / KilosToPounds

        def weightInKilos_=(newWeight: Double): Unit = {
            weightInPounds = newWeight * KilosToPounds
        }

        def printWeight(): Unit = {
            printWeightInPounds()
            printWeightInKilos()
            println()
        }

        def printWeightInPounds(): Unit = {
            println("Weight in Pounds: " + weightInPounds)
        }

        def printWeightInKilos(): Unit = {
            println("Weight In Kilos : " + weightInKilos)
        }
    }

    val fred = new Person("Fred", 120)

    fred.printWeight()

    // identical
    fred.weightInKilos = 60
    fred.weightInKilos_=(60)

    fred.printWeight()

    fred.weightInPounds = 125

    fred.printWeight()

}
