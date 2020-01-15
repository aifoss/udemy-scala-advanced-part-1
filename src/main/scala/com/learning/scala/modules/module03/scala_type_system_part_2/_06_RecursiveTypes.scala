package com.learning.scala.modules.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _06_RecursiveTypes extends App {

    trait CompareT[T] {
        def <(other: T): Boolean
        def >(other: T): Boolean
    }

    def genericInsert[T <: CompareT[T]](item: T, rest: List[T]): List[T] = {
        rest match {
            case Nil =>
                List(item)
            case head :: _ if item < head =>
                item :: rest
            case head :: tail =>
                head :: genericInsert(item, tail)
        }
    }

    def genericSort[T <: CompareT[T]](list: List[T]): List[T] = {
        list match {
            case Nil =>
                Nil
            case head :: tail =>
                genericInsert(head, genericSort(tail))
        }
    }

    // F-Bounded Polymorphism

    case class Distance(meters: Int) extends CompareT[Distance] {
        def <(other: Distance): Boolean = this.meters < other.meters
        def >(other: Distance): Boolean = this.meters > other.meters
    }

    val dists = List(Distance(10), Distance(12), Distance(7))

    val sortedD = genericSort(dists)

    println(sortedD)

    case class EngineSize(ci: Int) extends CompareT[EngineSize] {
        def <(other: EngineSize): Boolean = this.ci < other.ci
        def >(other: EngineSize): Boolean = this.ci > other.ci
    }

    val engines = List(EngineSize(454), EngineSize(232), EngineSize(356))

    val sortedE = genericSort(engines)

    println(sortedE)

    case class Person(first: String, last: String, age: Int) extends CompareT[Person] {
        def <(other: Person): Boolean =
            if (this.last < other.last) true else false
        def >(other: Person): Boolean =
            if (this.last > other.last) true else false
    }

    val people = List(
        Person("Harry", "Potter", 20),
        Person("Charlie", "Potter", 20),
        Person("Harry", "Dumbledore", 45)
    )

    val sortedP = genericSort(people)

    println(sortedP)

}
