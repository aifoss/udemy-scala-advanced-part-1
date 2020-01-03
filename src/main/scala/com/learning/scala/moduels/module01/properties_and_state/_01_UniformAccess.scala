package com.learning.scala.moduels.module01.properties_and_state

/**
 * Created by sofia on 2020-01-02.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_UniformAccess extends App {

    val KilosToPounds = 2.20462262185

    case class Potato(weightInKilos: Double) {
        // computed once
        val weightInPounds = weightInKilos * KilosToPounds
    }

    val potato = Potato(0.75)

    println("Weight in Kilos : " + potato.weightInKilos)
    println("Weight in Pounds: " + potato.weightInPounds)

    case class Person(name: String, weightInPounds: Double) {
        // computed each time
        def weightInKilos: Double = weightInPounds / KilosToPounds
    }

    val person = Person("Fred", 120)

    println("Weight in Kilos : " + person.weightInKilos)
    println("Weight in Pounds: " + person.weightInPounds)

}
