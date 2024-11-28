package com.example.dto.item;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
    @NotBlank(message="Item's mame cannot be blank")
    private String name;

    @NotBlank(message="Item's description cannot be blank")
    private String description;

    @NotNull(message = "Category ID is required")
    private UUID categoryId;

    @Positive(message = "Price must be positive")
    private double price;
}
