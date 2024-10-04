package com.example.controller

import com.example.dto.security.AuthRequest
import com.example.dto.security.AuthResponse
import com.example.service.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/sign")
class AuthenticationController(
    private val authenticationService: AuthenticationService,
) {
    @PostMapping("/in")
    fun authenticate(@RequestBody authRequest: AuthRequest): AuthResponse {
        return authenticationService.authenticate(authRequest)
    }

    @PostMapping("/up")
    fun registrate(@RequestBody authRequest: AuthRequest): AuthResponse {
        return authenticationService.registrate(authRequest)
    }
}