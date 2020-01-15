package com.learning.scala.moduels.module05.implicits_part_1

import scala.annotation.implicitNotFound

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _02_TypeClass extends App {

    @implicitNotFound("You need to define a CompareT for ${T}")
    abstract class CompareT[T] {
        def isSmaller(i1: T, i2: T): Boolean
        def isLarger(i1: T, i2: T): Boolean
    }

    def genericInsert[T](item: T, rest: List[T])(implicit cmp: CompareT[T]): List[T] = {
        rest match {
            case Nil => List(item)
            case head :: _ if cmp.isSmaller(item, head) => item :: rest
            case head :: tail => head :: genericInsert(item, tail)
        }
    }

    // implicitly
    def genericInsert2[T: CompareT](item: T, rest: List[T]): List[T] = {
        val cmp = implicitly[CompareT[T]]

        rest match {
            case Nil => List(item)
            case head :: _ if cmp.isSmaller(item, head) => item :: rest
            case head :: tail => head :: genericInsert2(item, tail)
        }
    }

    def genericInsert3[T: Ordering](item: T, rest: List[T]): List[T] = {
        val cmp = implicitly[Ordering[T]]

        rest match {
            case Nil => List(item)
            case head :: _ if cmp.lt(item, head) => item :: rest
            case head :: tail => head :: genericInsert3(item, tail)
        }
    }

    def genericSort[T](xs: List[T])(implicit cmp: CompareT[T]): List[T] = {
        xs match {
            case Nil => Nil
            case head :: tail => genericInsert(head, genericSort(tail))
        }
    }

    // implicit context bound
    def genericSort2[T: CompareT](xs: List[T]): List[T] = {
        xs match {
            case Nil => Nil
            case head :: tail => genericInsert2(head, genericSort2(tail))
        }
    }

    def genericSort3[T: Ordering](xs: List[T]): List[T] = {
        xs match {
            case Nil => Nil
            case head :: tail => genericInsert3(head, genericSort3(tail))
        }
    }

    val nums = List[Int](1,4,3,2,6,5)

    implicit val compareInts = new CompareT[Int] {
        override def isSmaller(i1: Int, i2: Int): Boolean = i1 < i2
        override def isLarger(i1: Int, i2: Int): Boolean = i1 > i2
    }

    println(genericSort(nums))

    case class Distance(meters: Int)

    val dists = List(Distance(10), Distance(4), Distance(12))

    implicit object DistCompare extends CompareT[Distance] {
        override def isSmaller(i1: Distance, i2: Distance): Boolean = i1.meters < i2.meters
        override def isLarger(i1: Distance, i2: Distance): Boolean = i1.meters > i2.meters
    }

    println(genericSort2(dists))

    case class Person(first: String, age: Int)

    object Person {
        implicit object PersonOrdering extends Ordering[Person] {
            override def compare(x: Person, y: Person): Int =
                x.age - y.age
        }
    }

//    implicit object PersonOrdering2 extends Ordering[Person] {
//        override def compare(x: Person, y: Person) = 0
//    }

    val people = List(
        Person("Fred", 25),
        Person("Sally", 22),
        Person("George", 53)
    )

    println(genericSort3(people))

}
