package com.example.service

import com.example.dto.security.AuthRequest
import com.example.dto.security.AuthResponse

interface AuthenticationService {
    fun authenticate(authRequest: AuthRequest): AuthResponse
    fun registrate(authRequest: AuthRequest): AuthResponse
}