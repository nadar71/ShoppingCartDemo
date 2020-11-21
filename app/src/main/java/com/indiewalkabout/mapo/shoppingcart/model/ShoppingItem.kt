package com.indiewalkabout.mapo.shoppingcart.model

data class ShoppingItem(
    var itemName: String = "",
    var price: Double = 0.0,
    var amount: Int = 0,
    var finalPrice: Double = 0.0
)