package com.example.dto.item;

import com.example.dto.category.CategoryDto;

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
public class ItemUpdateDto {
    private String name;
    private String description;
    private CategoryDto category;
}
