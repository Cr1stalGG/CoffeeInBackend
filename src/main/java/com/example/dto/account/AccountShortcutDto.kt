package com.example.dto.account

import com.example.dto.image.ImageDto
import java.util.UUID

data class AccountShortcutDto(
    val uuid: UUID,
    val nickname: String?,
    val login: String,
    val image: ImageDto?
)
