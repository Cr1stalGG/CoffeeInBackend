package com.example.dto.item

import com.example.dto.category.CategoryDto
import com.example.dto.image.ImageDto
import org.springframework.data.redis.core.RedisHash
import java.util.UUID

@RedisHash("items")
data class ItemDto(
    val uuid: UUID,
    val name: String,
    val description: String,
    val price: Double,
    val category: CategoryDto,
    val image: ImageDto?,
)
