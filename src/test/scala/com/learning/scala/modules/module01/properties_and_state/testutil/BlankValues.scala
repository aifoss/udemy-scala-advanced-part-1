package com.learning.scala.modules.module01.properties_and_state.testutil

/**
 * Created by sofia on 2020-01-02.
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
