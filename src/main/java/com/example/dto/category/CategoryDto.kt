package com.example.dto.category

import org.springframework.data.redis.core.RedisHash
import java.util.UUID

@RedisHash("categories")
data class CategoryDto(
    val uuid: UUID,
    val name: String,
    val description: String,
)
