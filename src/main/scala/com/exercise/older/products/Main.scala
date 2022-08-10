package com.exercise.older.products

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.util.Try

object Main extends App {

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
    }
    else {
      println("There seems to be some problem with the dates, try again!")
    }
  } else {
    println("There seems to be some problem with the arguments, try again!")
  }
}
