package com.example.dto

import com.example.entity.Order
import java.sql.Date
import java.util.UUID

data class TransactionDto(
    val uuid: UUID,
    val timeOfTransaction: Date,
    val order: Order,
)
