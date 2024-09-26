package com.example.dto.item;

import com.example.entity.Category;
import com.example.entity.Image;
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
    private Category category;
    private Image image;
}
