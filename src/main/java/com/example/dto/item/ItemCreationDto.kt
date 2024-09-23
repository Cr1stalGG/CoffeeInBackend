package com.example.dto.item

import java.util.UUID

data class ItemCreationDto(
    val name: String,
    val description: String,
    val categoryId: UUID,
    val price: Double,
)
