package com.learning.scala.moduels.module05.implicits_part_1

/**
 * Created by sofia on 2020-01-12.
 */

/**
 * Source: Udemy Scala Advanced, Part 1 Course
 */
object _01_ImplicitParams extends App {

    case class RetryParams(times: Int)

    import scala.util.control.NonFatal

    def retryCall[A](fn: => A, currentTry: Int = 0)(retryParams: RetryParams): A = {
        try fn
        catch {
            case NonFatal(ex) if currentTry < retryParams.times =>
                retryCall(fn, currentTry+1)(retryParams)
        }
    }

    def retry[A](fn: => A)(implicit retryParams: RetryParams): A = {
        retryCall(fn, 0)(retryParams)
    }

    var x = 0

    def checkIt(): Int = {
        x = x + 1
        println(s"Checking $x")
        require(x > 4, "x not big enough")
        x
    }

//    retry {
//        println("Retrying...")
//        checkIt()
//    }(RetryParams(5))

    implicit val retries = RetryParams(5)

    retry {
        println("Retrying with implicit params")
        checkIt()
    }

//    retry {
//        println("Trying")
//        1 / 0
//    }

    import scala.concurrent._
    import ExecutionContext.Implicits.global

//    Future(1)(global)
    Future(1)

}
