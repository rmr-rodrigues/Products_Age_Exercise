package com.exercise.older.products

import com.exercise.older.products.item.Item
import com.exercise.older.products.order.Order
import com.exercise.older.products.product.Product

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

object MainData {

  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  val date20180101: LocalDateTime = LocalDateTime.parse("2018-01-01 00:00:00", formatter)
  val date20180501: LocalDateTime = LocalDateTime.parse("2018-05-01 00:00:00", formatter)
  val date20181201: LocalDateTime = LocalDateTime.parse("2018-12-01 00:00:00", formatter)
  val date20190101: LocalDateTime = LocalDateTime.parse("2019-01-01 00:00:00", formatter)
  val date20180102: LocalDateTime = LocalDateTime.parse("2018-01-02 00:00:00", formatter)
  val date20181231: LocalDateTime = LocalDateTime.parse("2018-12-31 00:00:00", formatter)
  val date20180201: LocalDateTime = LocalDateTime.parse("2018-02-01 00:00:00", formatter)
  val date20180301: LocalDateTime = LocalDateTime.parse("2018-03-01 00:00:00", formatter)

  val product1: Product = Product("Product1", "Category1", 2.5f, 5.0, date20180101)
  val product2: Product = Product("Product1", "Category1", 2.5f, 5.0, date20180201)
  val product3: Product = Product("Product1", "Category1", 2.5f, 5.0, date20180301)

  val item1: Item = Item(10.0, 5.0, 1.0, product1)
  val item2: Item = Item(10.0, 5.0, 1.0, product2)
  val item3: Item = Item(10.0, 5.0, 1.0, product3)

  val order1: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(item1, item2, item3))
  val order2: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20190101, List(item3))

  val ordersList: List[Order] = List(order1, order2)

}
