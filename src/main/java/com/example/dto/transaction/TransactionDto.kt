package com.example.dto.transaction

import com.example.dto.order.OrderDto
import java.sql.Date
import java.util.*

data class TransactionDto(
    val uuid: UUID,
    val timeOfTransaction: Date,
    val order: OrderDto,
)
