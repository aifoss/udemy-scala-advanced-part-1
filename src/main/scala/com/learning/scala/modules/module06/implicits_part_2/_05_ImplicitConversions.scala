package com.learning.scala.modules.module06.implicits_part_2

/**
 * Created by sofia on 2020-01-14.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _05_ImplicitConversions extends App {

    case class Complex(real: Double, imaginary: Double = 0.0) {
        private def sign = if (imaginary >= 0.0) "+" else "-"
        override def toString = s"$real $sign ${imaginary.abs}i"

        def +(other: Complex) =
            Complex(real + other.real, imaginary + other.imaginary)
    }

    object Complex {
        implicit def intToComplex(i: Int): Complex = Complex(i)
    }

    val c1 = Complex(5, 6)

    println(c1 + 10)
    println(10 + c1)
    println(Complex.intToComplex(10) + c1)

}
