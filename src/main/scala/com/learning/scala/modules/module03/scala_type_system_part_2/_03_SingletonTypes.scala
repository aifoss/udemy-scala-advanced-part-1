package com.learning.scala.modules.module03.scala_type_system_part_2

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _03_SingletonTypes extends App {

    val h = "hello"

    def say(hello: h.type): Unit = println(hello)

    say(h)

    // this does not work, even though the string contents are the same
    //say("hello")

    // A Shakespearian DSL that uses singleton types
    val or = "or"
    val to = "to"

    object To {
        def be(o: or.type) = this
        def not(t: to.type) = this
        def be = "That is the question"
    }

    println(To be or not to be)
    println(To.be(or).not(to).be)

    println(To not to be or be)
    println(To.not(to).be(or).be)

}