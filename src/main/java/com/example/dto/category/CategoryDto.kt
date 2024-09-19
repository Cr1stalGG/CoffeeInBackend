package com.example.dto.category

import java.util.UUID

data class CategoryDto(
    val uuid: UUID,
    val name: String,
    val description: String,
)
