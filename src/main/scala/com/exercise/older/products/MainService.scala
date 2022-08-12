package com.exercise.older.products

import com.exercise.older.products.order.Order

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit
import scala.util.Try

object MainService {


  def ordersInTheInterval(
                           orders: List[Order],
                           startDate: LocalDateTime,
                           endDate: LocalDateTime
                         ): Option[List[Order]] = {

    // TODO Verify if is better to insert the start and end date inclusive
    val list = orders.filter(order => order.placedAt.isAfter(startDate) && order.placedAt.isBefore(endDate))

    if (list == List.empty[Order]) None
    else
      Some(list)
  }

  def datesDifferenceInMonths(
                               orderDate: LocalDateTime,
                               productDate: LocalDateTime
                             ): Option[Int] = {

    val diff = ChronoUnit.MONTHS.between(productDate, orderDate)

    if (diff > 0 && diff.isValidInt)
      Some(diff.toInt)
    else
      None
  }

  def orderProductsAges(order: Order): List[Int] = {
    order.
      items.flatMap(item => datesDifferenceInMonths(order.placedAt, item.product.creationDate))
  }

  def ordersToMapOfAges(orders: List[Order]): Map[Int, Int] = {

    val productsAges: List[Int] = orders.flatMap(orderProductsAges)

    productsAges.groupBy(identity).view.mapValues(l => l.length).toMap
  }

  def intervalToList(tuple: (Int, Int)): List[Int] = {
    tuple match {
      case (start, end) if end > start && start > 0 => (start to end).toList
      case (_, _) => List.empty[Int]
    }
  }

  def groupAgesByInterval(agesInterval: List[Int], ages: Map[Int, Int]): Int = {
    agesInterval.foldLeft(0) { (a, b) =>
      if (ages.contains(b)) a + ages(b)
      else a
    }
  }

  def insertAgesInToFinalMap(intervals: List[(Int, Int)], ages: Map[Int, Int]): Map[(Int, Int), Int] = {

    val finalMaps: List[Map[(Int, Int), Int]] = intervals.map {
      i =>
        // If the interval is just grater than
        if (i._1 > i._2) {
          val interval = ages.keys.filter(_ > i._1).toList
          val intervalTotal = groupAgesByInterval(interval, ages)
          if (intervalTotal > 0) Map((i._1, i._2) -> intervalTotal)
          else Map.empty[(Int, Int), Int]
          // Normal interval with start and end values
        } else {
          val interval = intervalToList(i)
          val intervalTotal = groupAgesByInterval(interval, ages)
          if (intervalTotal > 0) Map((i._1, i._2) -> intervalTotal)
          else Map.empty[(Int, Int), Int]
        }
    }

    finalMaps.foldLeft(Map.empty[(Int, Int), Int])(_ ++ _)
  }

  def finalMapToString(intervalsOfAges: Map[(Int, Int), Int]): String = {
    // (1, 3) (4, 6) (7, 12) (12, -1)
    val mapToSortedList = intervalsOfAges.toList.sorted

    "\n" + mapToSortedList.map {
      case ((s, e), value) if e > 0 => s"$s-$e months: $value orders"
      case ((s, -1), value) => s">$s months: $value orders"
    }.mkString("\n")
  }

  def parseStringToIntervals(string: String): List[(Int, Int)] = {
    // string format = "(1-3, 4-6, 7-12, >12)"

    val validateIntervalRegex = """(^\d+-\d+)""".r
    val validateGreaterThanInterval = """(^>\d+)""".r
    val validateMinorThanInterval = """(^<\d+)""".r

    def stringToTuple(s: String): Option[(Int, Int)] = {

      def stringIntervalToOption(string: String): Option[(Int, Int)] = {
        val values = string.split("-")

        Try {
          (values(0).toInt, values(1).toInt)
        }.toOption match {
          case Some(value) if value._1 >= value._2 => None
          case Some(value) => Some(value)
          case None => None
        }
      }

      def stringGreaterThanToOption(string: String): Option[(Int, Int)] = {
        val value = string.substring(1)
        Try {
          (value.toInt, -1)
        }.toOption
      }

      def stringMinorThanToOption(string: String): Option[(Int, Int)] = {
        val value = string.substring(1)
        Try {
          (-1, value.toInt)
        }.toOption
      }

      s match {
        case ss if validateIntervalRegex.matches(ss) => stringIntervalToOption(ss)
        case ss if validateGreaterThanInterval.matches(ss) => stringGreaterThanToOption(ss)
        case ss if validateMinorThanInterval.matches(ss) => stringMinorThanToOption(ss)
        case _ => None
      }

    }

    if (string.length >= 4) {
      val strings = string.substring(1, string.length - 1).split(",").map(_.trim).toList

      strings.flatMap(stringToTuple)
    } else
      List.empty[(Int, Int)]
  }
}
