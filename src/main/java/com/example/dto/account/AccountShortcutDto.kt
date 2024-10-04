package com.example.dto.account

import com.example.dto.image.ImageDto
import org.springframework.data.redis.core.RedisHash
import java.util.UUID

@RedisHash("accounts")
data class AccountShortcutDto(
    val uuid: UUID,
    val nickname: String?,
    val login: String,
    val image: ImageDto?
)
