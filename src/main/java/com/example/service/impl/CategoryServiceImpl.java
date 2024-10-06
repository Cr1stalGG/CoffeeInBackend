package com.example.service.impl;

import com.example.dto.category.CategoryCreationDto;
import com.example.dto.category.CategoryDto;
import com.example.dto.mapper.CategoryDtoMapper;
import com.example.entity.Category;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> findAll(){
        return categoryRepository.findAll().stream()
                .map(CategoryDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public CategoryDto findById(UUID uuid){
        Category category= categoryRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return CategoryDtoMapper.convertEntityToDto(category);
    }

    @Override
    public CategoryDto save(CategoryCreationDto creationDto){
        Category category = CategoryDtoMapper.convertDtoToEntity(creationDto);
        categoryRepository.save(category);
        return CategoryDtoMapper.convertEntityToDto(category);
    }

    @Override
    public void deleteById(UUID uuid){
        Category category = categoryRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        categoryRepository.deleteById(uuid);
    }
}
