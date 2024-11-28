package com.example.controllers;

import com.example.dto.security.AuthRequest;
import com.example.dto.security.AuthResponse;
import com.example.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @PostMapping("/login")
    public AuthResponse login(@RequestBody AuthRequest request) {
        return authenticationService.authenticate(request);
    }

    @PostMapping("/reg")
    public AuthResponse registrate(@RequestBody AuthRequest request) {
        return authenticationService.registrate(request);
    }
}
