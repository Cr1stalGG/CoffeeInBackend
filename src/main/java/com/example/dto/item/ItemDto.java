package com.example.dto.item;

import java.util.UUID;
import com.example.dto.category.CategoryDto;
import com.example.dto.image.ImageDto;

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
public class ItemDto {
    private UUID uuid;
    private String name;
    private String description;
    private Double price;
    private CategoryDto category;
    private ImageDto image;
}
