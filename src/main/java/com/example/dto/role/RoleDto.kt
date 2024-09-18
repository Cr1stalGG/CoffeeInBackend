package com.example.dto.role

import java.util.UUID

data class RoleDto(
    val uuid: UUID,
    val name: String,
    val description: String,
)
