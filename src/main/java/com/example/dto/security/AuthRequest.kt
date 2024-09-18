package com.example.dto.security

data class AuthRequest(
    val login: String,
    val password: String,
)
