package com.exercise.older.products.item

import com.exercise.older.products.product.Product

// information about the purchased item (cost, shipping fee, tax amount, ...)
final case class Item(cost: BigDecimal, shippingFee: BigDecimal, taAmount: BigDecimal, product: Product)
