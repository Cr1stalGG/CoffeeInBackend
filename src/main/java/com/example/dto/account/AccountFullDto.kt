package com.example.dto.account

import com.example.dto.card.CardDto
import com.example.dto.image.ImageDto
import com.example.dto.role.RoleDto
import java.util.UUID

data class AccountFullDto(
    val uuid: UUID,
    var nickname: String?,
    val login: String,
    val image: ImageDto?,
    val cards: List<CardDto>?,
    val roles: List<RoleDto>?,
)
