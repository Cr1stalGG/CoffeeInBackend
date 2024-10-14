package com.example.dto.security;

import com.example.dto.role.RoleDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse {
    private UUID uuid;
    private String token;
    private List<RoleDto> roles;
}
