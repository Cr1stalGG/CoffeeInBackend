package com.example.dto.security

import com.fasterxml.jackson.annotation.JsonProperty

data class AuthRequest(
    @JsonProperty("login")
    val login: String,
    @JsonProperty("password")
    val password: String,
    @JsonProperty("nickname")
    val nickname: String,
)
