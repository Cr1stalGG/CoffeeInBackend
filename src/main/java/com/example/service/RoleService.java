package com.example.service;

import com.example.dto.role.RoleDto;
import java.util.List;
import java.util.UUID;

public interface RoleService {
    List<RoleDto> findAll();
    RoleDto findById(UUID uuid);
    RoleDto save(RoleDto creationDto);
    void deleteById(UUID uuid);
}
