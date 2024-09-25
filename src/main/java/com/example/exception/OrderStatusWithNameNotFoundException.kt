package com.example.exception

class OrderStatusWithNameNotFoundException(
    newOrderStatusName: String,
): RuntimeException("Order status with name '$newOrderStatusName' not found")
