package com.example.dto.mapper

import com.example.dto.category.CategoryDto
import com.example.entity.Category
import lombok.experimental.UtilityClass

@UtilityClass
class CategoryDtoMapper {
    companion object {
        fun convertEntityToDto(source: Category): CategoryDto {
            return CategoryDto(
                uuid = source.id,
                name = source.name,
                description = source.description
            )
        }
    }
}