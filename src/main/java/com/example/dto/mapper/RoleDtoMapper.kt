package com.example.dto.mapper

import com.example.dto.role.RoleDto
import com.example.entity.Role

object RoleDtoMapper {
    fun convertEntityToDto(source: Role): RoleDto {
        return RoleDto(
            uuid = source.id,
            name = source.name,
            description = source.description
        )
    }
}