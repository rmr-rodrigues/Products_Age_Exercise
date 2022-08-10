package com.exercise.older.products

import com.exercise.older.products.MainData._
import com.exercise.older.products.MainService.{orderProductAges, ordersInTheInterval, ordersToMapOfAges}

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.util.Try

object Main extends App {
// "2018-01-01 00:00:00" "2019-01-01 00:00:00"
  if (args.length == 2) {
    val startDate = args(0)
    val endDate = args(1)
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
      println(s"Start Date: $startDateTime - End Date: $endDatetime")
      println("---------------------------")
      // TODO Replace the get method for something that doesn't throw and exception
      println("Orders in the interval: " + ordersInTheInterval(ordersList, startDateTime.get, endDatetime.get))
//      println("---------------------------")
//      println(datesDifferenceInMonths(date20181231, date20180101))
//      println(datesDifferenceInMonths(date20181231, date20180501))
//      println(datesDifferenceInMonths(date20181231, date20181201))
//      println(datesDifferenceInMonths(date20181231, date20190101))
      println("---------------------------")
      println("Order1 Products age: " + orderProductAges(order1))
      println("Order2 Products age: " + orderProductAges(order2))
      println("Order3 Products age: " + orderProductAges(order3))
      println("---------------------------")
      val ages = ordersToMapOfAges(ordersList)//Map.empty[Int, Int]

      println(ages)
    }
    else {
      println("There seems to be some problem with the dates, try again!")
    }
  } else {
    println("There seems to be some problem with the arguments, try again!")
  }
}
