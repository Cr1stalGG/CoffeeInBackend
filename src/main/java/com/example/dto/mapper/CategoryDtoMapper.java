package com.example.dto.mapper;

import com.example.dto.category.CategoryCreationDto;
import com.example.dto.category.CategoryDto;
import com.example.entity.Category;
import lombok.experimental.UtilityClass;
import java.util.Optional;

@UtilityClass
public class CategoryDtoMapper {
    public static CategoryDto convertEntityToDto(Category source) {
        return Optional.ofNullable(source)
                .map(CategoryDtoMapper::buildDto)
                .orElse(null);
    }

    public static Category convertDtoToEntity(CategoryCreationDto source){
        return Optional.ofNullable(source)
                .map(CategoryDtoMapper::buildEntity)
                .orElse(null);
    }

    private static CategoryDto buildDto(Category source){
        return CategoryDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }

    private static Category buildEntity(CategoryCreationDto source){
        return Category.builder()
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}

