package com.example.dto.item;

import com.example.dto.category.CategoryDto;
import com.example.dto.image.ImageDto;
import java.util.UUID;

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
    private UUID id;
    private String name;
    private String description;
    private CategoryDto category;
    private ImageDto image;
}
