package com.example.dto.security

import com.example.dto.role.RoleDto
import java.util.*

data class AuthResponse(
    val uuid: UUID,
    val token: String,
    val roles: List<RoleDto>,
)
