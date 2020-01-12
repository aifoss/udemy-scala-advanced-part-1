package com.learning.scala.moduels.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_SelfReferencingTypes extends App {

    case class Distance(meters: Int) {

        def larger(other: Distance): Distance =
            if (other.meters > this.meters) other else this

        def smaller(other: Distance): Distance =
            if (other.meters < this.meters) other else this

        def >(other: Distance): Boolean = this.meters > other.meters
        def <(other: Distance): Boolean = this.meters < other.meters
    }

    val d1 = Distance(10)
    val d2 = Distance(12)

    println(d1.larger(d2))
    println(d1 larger d2)
    println(d1 < d2)

    def insertDistance(item: Distance, rest: List[Distance]): List[Distance] = {
        rest match {
            case Nil =>
                List(item)
            case head :: _ if item < head =>
                item :: rest
            case head :: tail =>
                head :: insertDistance(item, tail)
        }
    }

    def sortDistances(list: List[Distance]): List[Distance] = {
        list match {
            case Nil =>
                Nil
            case head :: tail =>
                insertDistance(head, sortDistances(tail))
        }
    }

    val dists = List(
        Distance(12),
        Distance(7),
        Distance(10)
    )

    val sorted = sortDistances(dists)

    println(sorted)

}
