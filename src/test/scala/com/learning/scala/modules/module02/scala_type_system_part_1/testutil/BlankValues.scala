package com.learning.scala.modules.module02.scala_type_system_part_1.testutil

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */

object BlankValues {

    class ReplaceWithCorrectException extends Exception

    val __ = "Should be filled in"

    class ___ extends ReplaceWithCorrectException {
        override def toString() = "___"
    }

}