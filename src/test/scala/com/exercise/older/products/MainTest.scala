package com.exercise.older.products

import com.exercise.older.products.MainData._
import org.scalatest.freespec.AnyFreeSpec
import org.scalatest.matchers.should.Matchers

class MainTest
  extends AnyFreeSpec
    with Matchers {

  "Filter orders in the interval should" - {
    "return Some(List[Order]) if the orders are in the interval" in {
      MainService.ordersInTheInterval(ordersList, date20180101, date20180501) shouldBe Some(List(order9, order15, order17))
      MainService.ordersInTheInterval(ordersList, date20170101, date20170301) shouldBe Some(List(order20))
      MainService.ordersInTheInterval(ordersList, date20160101, date20220801) shouldBe Some(List(order1, order2, order3, order4, order5, order6, order7, order8, order9,
        order10, order11, order12, order13, order14, order15, order16, order17, order18, order19, order20))
    }
    "return None if there is no order in the interval" in {
      MainService.ordersInTheInterval(ordersList, date20160101, date20170101) shouldBe None
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

  "Product ages in an order should" - {
    "return a list of ages in months" in {
      MainService.orderProductsAges(order1) shouldBe List(11, 10, 10, 9)
    }
    "return an empty list if product ages minor than one" in {
      MainService.orderProductsAges(order3) shouldBe List.empty
    }
  }

  "A list of orders that has products with ages" - {
    "bigger than 1 month should return a Map(age -> numberOfProductsWithThatAge)" in {
      MainService.ordersToMapOfAges(List(order1, order2)) shouldBe Map(10 -> 2, 9 -> 1, 11 -> 3)
      MainService.ordersToMapOfAges(List(order1)) shouldBe Map(10 -> 2, 9 -> 1, 11 -> 1)
      MainService.ordersToMapOfAges(List(order2)) shouldBe Map(11 -> 2)
      MainService.ordersToMapOfAges(List(order4)) shouldBe Map(21 -> 1, 9 -> 1, 23 -> 1)
      MainService.ordersToMapOfAges(List(order5)) shouldBe Map(5 -> 1, 1 -> 2)
      MainService.ordersToMapOfAges(List(order9)) shouldBe Map(1 -> 1)
      MainService.ordersToMapOfAges(List(order1, order2, order3, order4, order5)) shouldBe Map(5 -> 1, 10 -> 2, 1 -> 2, 21 -> 1, 9 -> 2, 11 -> 3, 23 -> 1)
    }
    "less than 1 month should return an empty Map" in {
      MainService.ordersToMapOfAges(List(order19)) shouldBe Map.empty
      MainService.ordersToMapOfAges(List(order3)) shouldBe Map.empty
    }
  }

  "Converting an interval in the form of a tuple returns" - {
    "a list of all the values in that interval if the tuple is valid" in {
      MainService.intervalToList((1, 5)) shouldBe List(1, 2, 3, 4, 5)
      MainService.intervalToList((2, 3)) shouldBe List(2, 3)
    }
    "an empty list if the tuple is of type greater than" in {
      MainService.intervalToList((2, -1)) shouldBe List()
    }
    "an empty list if the tuple is not a valid interval" in {
      MainService.intervalToList((2, 2)) shouldBe List.empty
      MainService.intervalToList((2, 1)) shouldBe List.empty
      MainService.intervalToList((-2, -1)) shouldBe List.empty
    }
  }

  "To sum the number of products with age in an interval returns " - {
    val m = Map(1 -> 1, 2 -> 1, 3 -> 1, 4 -> 1, 5 -> 1, 6 -> 1, 7 -> 2, 8 -> 3)

    "a value grater than 0 if there are values in the Map for that interval" in {
      MainService.groupAgesByInterval(List(1), m) shouldBe 1
      MainService.groupAgesByInterval(List(1, 2), m) shouldBe 2
      MainService.groupAgesByInterval(List(1, 2, 3), m) shouldBe 3
      MainService.groupAgesByInterval(List(6, 7, 8), m) shouldBe 6
    }
    "zero if there are no values in the Map for that interval" in {
      MainService.groupAgesByInterval(List(0), m) shouldBe 0
      MainService.groupAgesByInterval(List(9), m) shouldBe 0
    }
  }

  "Create a Map with the keys as tuple for" - {
    val m = Map(1 -> 1, 2 -> 1, 3 -> 1, 4 -> 1, 5 -> 1, 6 -> 1, 7 -> 2, 8 -> 3)

    "a normal interval with a start and end values" in {
      MainService.insertAgesInToFinalMap(List((1, 2)), m) shouldBe Map((1, 2) -> 2)
      MainService.insertAgesInToFinalMap(List((1, 3)), m) shouldBe Map((1, 3) -> 3)
      MainService.insertAgesInToFinalMap(List((6, 8)), m) shouldBe Map((6, 8) -> 6)

    }
    "an interval greater than" in {
      MainService.insertAgesInToFinalMap(List((7, -1)), m) shouldBe Map((7, -1) -> 3)
      MainService.insertAgesInToFinalMap(List((1, -1)), m) shouldBe Map((1, -1) -> 10)
    }
    "an interval than has no keys returns an empty Map" in {
      MainService.insertAgesInToFinalMap(List((8, -1)), m) shouldBe Map.empty
      MainService.insertAgesInToFinalMap(List((9, 12)), m) shouldBe Map.empty
    }
  }

  "Parsing an args string with intervals returns" - {
    "a list of tuples with start and end values of the interval" in {
      MainService.parseStringToIntervals("(1-3)") shouldBe List((1, 3))
      MainService.parseStringToIntervals("(1-3, 4-6)") shouldBe List((1, 3), (4, 6))
      MainService.parseStringToIntervals("(1-3, 4-6, 7-12, >12)") shouldBe List((1, 3), (4, 6), (7, 12), (12, -1))
      MainService.parseStringToIntervals("(1-3, 4-6, 7-12)") shouldBe List((1, 3), (4, 6), (7, 12))
    }
    "a list of tuples where the second value of the tuple is -1 (indicates an interval greater than)" in {
      MainService.parseStringToIntervals("(>12)") shouldBe List((12, -1))
      MainService.parseStringToIntervals("(>11)") shouldBe List((11, -1))
      MainService.parseStringToIntervals("(>5)") shouldBe List((5, -1))
      MainService.parseStringToIntervals("(>12, >10, >9)") shouldBe List((12, -1), (10, -1), (9, -1))
    }
    "an empty list if the tuples are not valid intervals" in {
      MainService.parseStringToIntervals("(2-1)") shouldBe List.empty
      MainService.parseStringToIntervals("(2-2)") shouldBe List.empty
    }
  }

}