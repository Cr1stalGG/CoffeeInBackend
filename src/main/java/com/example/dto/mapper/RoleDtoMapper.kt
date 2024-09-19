package com.example.dto.mapper

import com.example.dto.role.RoleDto
import com.example.entity.Role
import lombok.experimental.UtilityClass

@UtilityClass
class RoleDtoMapper {
    companion object {
        fun convertEntityToDto(source: Role): RoleDto {
            return RoleDto(
                uuid = source.id,
                name = source.name,
                description = source.description
            )
        }
    }
}