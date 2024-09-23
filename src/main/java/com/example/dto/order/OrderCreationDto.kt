package com.example.dto.order

import java.util.UUID

data class OrderCreationDto(
    val accountId: UUID,
    val itemsId: List<UUID>,
)
