package com.exercise.older.products.order

import com.exercise.older.products.item.Item

import java.time.LocalDateTime

//Order: contains general information about the order (customer name and contact,
//shipping address, grand total, date when the order was placed, ...)
final case class Order(
                  customerName: String,
                  customerPhone: String,
                  shippingAddress: String,
                  grandTotal: BigDecimal,
                  placedAt: LocalDateTime,
                  items: List[Item]
                )
