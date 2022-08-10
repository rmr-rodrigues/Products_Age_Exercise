package com.exercise.older.products

import com.exercise.older.products.order.Order

import java.time.LocalDateTime

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




}
