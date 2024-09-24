package com.example.dto.order_status

import java.util.UUID

data class OrderStatusDto(
    val uuid: UUID,
    val name: String,
    val description: String,
)
