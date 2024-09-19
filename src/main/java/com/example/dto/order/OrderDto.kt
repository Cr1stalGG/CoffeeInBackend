package com.example.dto.order

import java.sql.Date
import java.util.*

data class OrderDto(
    val uuid: UUID,
    val closingTime: Date,
    val items: List<ItemDto>
)
