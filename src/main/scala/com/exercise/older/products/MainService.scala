package com.exercise.older.products

import com.exercise.older.products.order.Order

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

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

    val diff = ChronoUnit.MONTHS.between(orderDate, productDate)

    if (diff > 0 && diff.isValidInt)
      Some(diff.toInt)
    else
      None

  }


}
