package com.example.dto.category;

import jakarta.validation.constraints.NotBlank;
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
public class CategoryCreationDto {

    @NotBlank(message="Category's name cannot be blank")
    private String name;

    @NotBlank(message="Category's description cannot be blank")
    private String description;
}
