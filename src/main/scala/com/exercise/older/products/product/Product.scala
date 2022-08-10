package com.exercise.older.products.product

import java.time.LocalDateTime

// Product: information about the product (name, category, weight, price, creation date, ...)
final case class Product(name: String, category: String, weight: Float, price: BigDecimal, creationDate: LocalDateTime)
