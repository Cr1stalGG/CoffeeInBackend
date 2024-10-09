package com.example.dto.mapper;

import com.example.dto.role.RoleDto;
import com.example.entity.Role;
import lombok.experimental.UtilityClass;
import java.util.Optional;

@UtilityClass
public class RoleDtoMapper {
    public static RoleDto convertEntityToDto(Role source) {
        return Optional.ofNullable(source)
                .map(RoleDtoMapper::buildDto)
                .orElse(null);
    }

    private static RoleDto buildDto(Role source){
        return RoleDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
