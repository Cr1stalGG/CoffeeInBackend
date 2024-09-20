package com.example.dto.category;

import com.example.entity.Item;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryFullDto {
    private UUID id;
    private String name;
    private String description;
    private List<Item> items;
}
