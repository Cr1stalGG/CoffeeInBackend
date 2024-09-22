package com.example.dto.category;

import java.util.List;
import java.util.UUID;
import com.example.dto.item.ItemDto;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private UUID id;
    private String name;
    private String description;
}
