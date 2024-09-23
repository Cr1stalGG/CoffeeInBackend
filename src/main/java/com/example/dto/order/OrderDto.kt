package com.example.dto.order

import com.example.dto.item.ItemDto
import java.sql.Date
import java.util.*

data class OrderDto(
    val uuid: UUID,
    val closingTime: Date,
    val items: List<ItemDto>,
    val summaryPrice: Double,
)
