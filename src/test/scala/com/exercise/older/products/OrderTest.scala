package com.exercise.older.products

import com.exercise.older.products.OrderTest._
import com.exercise.older.products._
import com.exercise.older.products.item.Item
import com.exercise.older.products.order.Order
import com.exercise.older.products.product.Product
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class OrderTest
  extends AnyFreeSpec
    with Matchers {

  "Filter orders in the interval should" - {
    "return Some(List[Order]) if not empty" in {
      MainService.ordersInTheInterval(ordersList, date1LDT, date4LDT) shouldBe Some(List(order1))
    }
    "return None if empty List" in {
      MainService.ordersInTheInterval(ordersList, date3LDT, date4LDT) shouldBe None
    }
  }

  "Dates difference in months should" - {
    "return Some(Int) if dates are valid" in {
      MainService.datesDifferenceInMonths(date1LDT, date2LDT) shouldBe Some(4)
      MainService.datesDifferenceInMonths(date1LDT, date3LDT) shouldBe Some(11)
      MainService.datesDifferenceInMonths(date1LDT, date4LDT) shouldBe Some(12)
    }
    "return None if interval less than one month" in {
      MainService.datesDifferenceInMonths(date1LDT, date5LDT) shouldBe None
      MainService.datesDifferenceInMonths(date1LDT, date1LDT) shouldBe None
    }
    "return None if dates invalid" in {
      MainService.datesDifferenceInMonths(date2LDT, date1LDT) shouldBe None
    }
  }
}

object OrderTest {
  val formatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

  val date1: String = "2018-01-01 00:00:00"
  val date2: String = "2018-05-01 00:00:00"
  val date3: String = "2018-12-01 00:00:00"
  val date4: String = "2019-01-01 00:00:00"
  val date5: String = "2018-01-02 00:00:00"

  val date1LDT: LocalDateTime = LocalDateTime.parse(date1, formatter)
  val date2LDT: LocalDateTime = LocalDateTime.parse(date2, formatter)
  val date3LDT: LocalDateTime = LocalDateTime.parse(date3, formatter)
  val date4LDT: LocalDateTime = LocalDateTime.parse(date4, formatter)
  val date5LDT: LocalDateTime = LocalDateTime.parse(date5, formatter)

  val product1Date: String = "2018-01-01 00:00:00"
  val product2Date: String = "2018-02-01 00:00:00"
  val product3Date: String = "2018-03-01 00:00:00"


  val product1: Product = Product("Product1","Category1",2.5f, 5.0, LocalDateTime.parse(product1Date, formatter))
  val product2: Product = Product("Product1","Category1",2.5f, 5.0, LocalDateTime.parse(product1Date, formatter))
  val product3: Product = Product("Product1","Category1",2.5f, 5.0, LocalDateTime.parse(product1Date, formatter))

  val item1: Item = Item(10.0, 5.0, 1.0, product1)
  val item2: Item = Item(10.0, 5.0, 1.0, product2)
  val item3: Item = Item(10.0, 5.0, 1.0, product3)

 val order1: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, LocalDateTime.parse(date2, formatter), List(item1, item2, item3))
 val order2: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, LocalDateTime.parse(date4, formatter), List(item3))

  val ordersList: List[Order] = List(order1, order2)
}
