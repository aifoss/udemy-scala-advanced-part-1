package com.learning.scala.moduels.module04.scala_type_system_part_3

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_SelfTypesAndAliases extends App {

    case class Person1(name: String) {
        case class LifePartner(name: String) {
            def describe: String = s"$name loves $name"
        }
    }

    val p1 = Person1("Fred")
    val p1a = p1.LifePartner("Sally")

    println(p1a.describe)

    case class Person2(name: String) { outer =>
        case class LifePartner(name: String) {
            def describe: String = s"${this.name} loves ${outer.name}"
        }
    }

    val p2 = Person2("Fred")
    val p2a = p2.LifePartner("Sally")

    println(p2a.describe)

    // Self Types with Requirements

    import com.typesafe.scalalogging._

    trait Loves { this: LazyLogging =>
        def loves(i1: AnyRef, i2: AnyRef): Unit =
            logger.info(s"$i1 loves $i2")
    }

    case class Lovers(name1: String, name2: String) extends Loves with LazyLogging {
        def describe: Unit = loves(name1, name2)
    }

    Lovers("Fred", "Sally").describe

}
