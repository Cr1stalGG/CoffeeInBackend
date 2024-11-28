package com.example.service;

import com.example.dto.security.AuthRequest;
import com.example.dto.security.AuthResponse;

public interface AuthenticationService {
    AuthResponse authenticate(AuthRequest request);
    AuthResponse registrate(AuthRequest request);
}
