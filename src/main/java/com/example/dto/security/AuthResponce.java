package com.example.dto.security;

import com.example.dto.role.RoleDto;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AuthResponce {
    private UUID uuid;
    private String token;
    private List<RoleDto> roles;
}
