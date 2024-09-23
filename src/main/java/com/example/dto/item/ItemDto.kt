package com.example.dto.item

import com.example.dto.category.CategoryDto
import com.example.dto.image.ImageDto
import java.util.UUID

data class ItemDto(
    val uuid: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val category: CategoryDto,
    val image: ImageDto?,
)
