package com.example.exception

class CannotChangeOrderStatusException(
    statusName: String,
) : RuntimeException("Cannot change order status with name $statusName")
