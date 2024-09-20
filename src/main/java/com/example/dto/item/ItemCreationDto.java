package com.example.dto.item;

import com.example.entity.Category;
import com.example.entity.Image;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemCreationDto {
    private String name;
    private String description;
    private Category category;
    private Image image;
}
