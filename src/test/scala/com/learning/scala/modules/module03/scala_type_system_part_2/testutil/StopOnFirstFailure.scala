package com.learning.scala.modules.module03.scala_type_system_part_2.testutil

import org.scalatest._

import scala.collection.mutable.ListBuffer

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
trait StopOnFirstFailure extends SuiteMixin { this: Suite =>

    override def runTests(testName: Option[String], args: Args): Status = {
        testName match {
            case Some(tn) => runTest(tn, args)
            case None =>
                val statusList = new ListBuffer[Status]()
                val tests = testNames.iterator
                var failed = false

                for (test <- tests) {
                    if (failed == false) {
                        val status = runTest(test, args)
                        statusList += status
                        failed = !status.succeeds()
                    }
                }

                new CompositeStatus(Set.empty ++ statusList)
        }
    }

}
