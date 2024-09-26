package com.example.dto.role;

import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RoleDto {
    private UUID uuid;
    private String name;
    private String description;
}
