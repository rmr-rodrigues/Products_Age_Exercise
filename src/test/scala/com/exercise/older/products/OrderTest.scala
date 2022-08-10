package com.exercise.older.products

import com.exercise.older.products.MainData._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class OrderTest
  extends AnyFreeSpec
    with Matchers {

  "Filter orders in the interval should" - {
    "return Some(List[Order]) if not empty" in {
      MainService.ordersInTheInterval(ordersList, date20180101, date20190101) shouldBe Some(List(order1))
    }
    "return None if empty List" in {
      MainService.ordersInTheInterval(ordersList, date20181201, date20190101) shouldBe None
    }
  }

  "Dates difference in months should" - {
    "return Some(Int) if dates are valid" in {
      MainService.datesDifferenceInMonths(date20180501, date20180101) shouldBe Some(4)
      MainService.datesDifferenceInMonths(date20181201, date20180101) shouldBe Some(11)
      MainService.datesDifferenceInMonths(date20190101, date20180101) shouldBe Some(12)
    }
    "return None if interval less than one month" in {
      MainService.datesDifferenceInMonths(date20180102, date20180501) shouldBe None
      MainService.datesDifferenceInMonths(date20180501, date20180501) shouldBe None
    }
    "return None if dates invalid" in {
      MainService.datesDifferenceInMonths(date20180101, date20180501) shouldBe None
    }
  }

  "Order product ages should" - {
    "return a list of ages in months" in {
      MainService.orderProductAges(order1) shouldBe List(11, 10, 9)
    }
  }
}