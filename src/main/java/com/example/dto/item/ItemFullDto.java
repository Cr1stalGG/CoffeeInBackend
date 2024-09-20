package com.example.dto.item;

import com.example.entity.Category;
import com.example.entity.Image;
import java.util.List;
import java.util.UUID;
import com.example.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemFullDto {
    private UUID id;
    private String name;
    private String description;
    private Category category;
    private Image image;
    private List<Order> orders;
}
