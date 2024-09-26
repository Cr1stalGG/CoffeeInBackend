package com.example.exception

class NotEnoughMoneyException(
    number: String,
    summaryPrice: Double
) : RuntimeException("Card '$number' less then order price: '$summaryPrice'")
