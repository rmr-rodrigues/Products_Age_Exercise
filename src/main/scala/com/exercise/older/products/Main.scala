package com.exercise.older.products

import com.exercise.older.products.MainData._
import com.exercise.older.products.MainService._

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.util.Try

object Main extends App {
  // "2018-01-01 00:00:00" "2019-01-01 00:00:00" "(1-3, 4-6, 7-12, >12)"
  val defaultIntervals = "(1-3, 4-6, 7-12, >12)"

  if (args.length >= 2 && args.length <=3) {
    val startDate = args(0)
    val endDate = args(1)
    val intervals = args.length match {
      case 2 => defaultIntervals
      case 3 => args(2)
    }

    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val startDateTime = Try {
      LocalDateTime.parse(startDate, formatter)
    }.toOption
    val endDatetime = Try {
      LocalDateTime.parse(endDate, formatter)
    }.toOption

    val datesAreValid = (for {
      s <- startDateTime
      e <- endDatetime
    } yield s.isBefore(e)).getOrElse(false)

    if (datesAreValid) {
      val result = for {
        startDate <- startDateTime
        endDate <- endDatetime
        optionOrders = ordersInTheInterval(ordersList, startDate, endDate)
        orders <- optionOrders
        allIntervals = parseStringToIntervals(intervals)
        ages = ordersToMapOfAges(orders)
        finalMap = insertAgesInToFinalMap(allIntervals, ages)
        finalString = finalMapToString(finalMap)
      } yield finalString

      result match {
        case Some(value) if value.isEmpty => println("There are no values to present!")
        case Some(value) => println(value)
        case None => println("There seems to be some problem with the arguments, try again!")
      }
    }
    else {
      println("There seems to be some problem with the dates, try again!")
    }
  } else {
    println("There seems to be some problem with the arguments, try again!")
  }
}
