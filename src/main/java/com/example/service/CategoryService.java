package com.example.service;

import com.example.dto.category.CategoryCreationDto;
import com.example.dto.category.CategoryDto;
import java.util.List;
import java.util.UUID;

public interface CategoryService {
    List<CategoryDto> findAll();
    CategoryDto findById(UUID uuuid);
    CategoryDto save(CategoryCreationDto creationDto);
    void deleteById(UUID uuid);
}
