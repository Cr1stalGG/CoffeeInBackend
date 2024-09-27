package com.example.dto.mapper

import com.example.dto.category.CategoryCreationDto
import com.example.dto.category.CategoryDto
import com.example.entity.Category

object CategoryDtoMapper {
    fun convertEntityToDto(source: Category): CategoryDto {
        return CategoryDto(
            uuid = source.id,
            name = source.name,
            description = source.description
        )
    }

    fun convertDtoToEntity(source: CategoryCreationDto): Category {
        return Category(
            source.name,
            source.description
        )
    }
}