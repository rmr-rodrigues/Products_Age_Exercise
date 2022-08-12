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
  val date20180115: LocalDateTime = LocalDateTime.parse("2018-01-15 00:00:00", formatter)
  val date20180505: LocalDateTime = LocalDateTime.parse("2018-05-05 00:00:00", formatter)
  val date20181215: LocalDateTime = LocalDateTime.parse("2018-12-15 00:00:00", formatter)
  val date20190131: LocalDateTime = LocalDateTime.parse("2019-01-31 00:00:00", formatter)
  val date20180602: LocalDateTime = LocalDateTime.parse("2018-06-02 00:00:00", formatter)
  val date20180831: LocalDateTime = LocalDateTime.parse("2018-08-31 00:00:00", formatter)
  val date20180901: LocalDateTime = LocalDateTime.parse("2018-09-01 00:00:00", formatter)
  val date20180315: LocalDateTime = LocalDateTime.parse("2018-03-15 00:00:00", formatter)
  val date20170101: LocalDateTime = LocalDateTime.parse("2017-01-01 00:00:00", formatter)
  val date20170102: LocalDateTime = LocalDateTime.parse("2017-01-02 00:00:00", formatter)
  val date20170301: LocalDateTime = LocalDateTime.parse("2017-03-01 00:00:00", formatter)
  val date20160101: LocalDateTime = LocalDateTime.parse("2016-01-01 00:00:00", formatter)
  val date20220801: LocalDateTime = LocalDateTime.parse("2022-08-01 00:00:00", formatter)

  val product1: Product = Product("Product1", "Category1", 2.5f, 5.0, date20180102)
  val product2: Product = Product("Product2", "Category1", 2.5f, 5.0, date20180201)
  val product3: Product = Product("Product3", "Category1", 2.5f, 5.0, date20180301)
  val product4: Product = Product("Product4", "Category1", 2.5f, 5.0, date20181231)
  val product5: Product = Product("Product1", "Category1", 2.5f, 5.0, date20180501)
  val product6: Product = Product("Product2", "Category1", 2.5f, 5.0, date20180115)
  val product7: Product = Product("Product3", "Category1", 2.5f, 5.0, date20180505)
  val product8: Product = Product("Product4", "Category1", 2.5f, 5.0, date20181215)
  val product11: Product = Product("Product3", "Category1", 2.5f, 5.0, date20180602)
  val product14: Product = Product("Product2", "Category1", 2.5f, 5.0, date20180831)
  val product15: Product = Product("Product3", "Category1", 2.5f, 5.0, date20180901)
  val product16: Product = Product("Product4", "Category1", 2.5f, 5.0, date20180101)
  val product17: Product = Product("Product3", "Category1", 2.5f, 5.0, date20170101)
  val product18: Product = Product("Product4", "Category1", 2.5f, 5.0, date20170301)
  val product19: Product = Product("Product4", "Category1", 2.5f, 5.0, date20190101)

  val itemDate20180102: Item = Item(10.0, 5.0, 1.0, product1)
  val itemDate20180201: Item = Item(10.0, 5.0, 1.0, product2)
  val itemDate20180301: Item = Item(10.0, 5.0, 1.0, product3)
  val itemDate20181231: Item = Item(10.0, 5.0, 1.0, product4)
  val itemDate20180501: Item = Item(10.0, 5.0, 1.0, product5)
  val itemDate20180115: Item = Item(10.0, 5.0, 1.0, product6)
  val itemDate20180505: Item = Item(10.0, 5.0, 1.0, product7)
  val itemDate20181215: Item = Item(10.0, 5.0, 1.0, product8)
  val itemDate20180101: Item = Item(10.0, 5.0, 1.0, product16)
  val itemDate20180602: Item = Item(10.0, 5.0, 1.0, product11)
  val itemDate20180831: Item = Item(10.0, 5.0, 1.0, product14)
  val itemDate20180901: Item = Item(10.0, 5.0, 1.0, product15)
  val itemDate20170101: Item = Item(10.0, 5.0, 1.0, product17)
  val itemDate20170301: Item = Item(10.0, 5.0, 1.0, product18)
  val itemDate20190101: Item = Item(10.0, 5.0, 1.0, product19)

  val order1: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(itemDate20180101, itemDate20180102, itemDate20180201, itemDate20180301))
  val order2: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20190101, List(itemDate20180102, itemDate20180115, itemDate20181231))
  val order3: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180901, List(itemDate20180831))
  val order4: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(itemDate20170101, itemDate20170301, itemDate20180301))
  val order5: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20190131, List(itemDate20190101, itemDate20180831, itemDate20181215, itemDate20181231))
  val order6: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20181215, List(itemDate20180501, itemDate20180115))
  val order7: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(itemDate20180115, itemDate20170101, itemDate20180901))
  val order8: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20180505, List(itemDate20180501, itemDate20180201))
  val order9: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180301, List(itemDate20180201))
  val order10: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(itemDate20180501, itemDate20180901, itemDate20180505))
  val order11: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20180602, List(itemDate20180501))
  val order12: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180831, List(itemDate20180501))
  val order13: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181201, List(itemDate20180901, itemDate20180501, itemDate20180505))
  val order14: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20180831, List(itemDate20180501))
  val order15: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180315, List(itemDate20180201))
  val order16: Order = Order("Client 1", "++351 999999999", "Address 1", 1.0, date20181215, List(itemDate20180201, itemDate20180602, itemDate20180501))
  val order17: Order = Order("Client 2", "++351 999999998", "Address 2", 2.0, date20180301, List(itemDate20180201))
  val order18: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180901, List(itemDate20180201, itemDate20180501))
  val order19: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20180831, List(itemDate20180831))
  val order20: Order = Order("Client 3", "++351 999999998", "Address 2", 2.0, date20170102, List(itemDate20170101))

  val ordersList: List[Order] = List(
    order1, order2, order3, order4, order5, order6, order7, order8, order9, 
    order10, order11, order12, order13, order14, order15, order16, order17, order18, order19, order20)

}
