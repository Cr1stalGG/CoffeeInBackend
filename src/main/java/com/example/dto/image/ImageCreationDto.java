package com.example.dto.image;

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
public class ImageCreationDto {

    @NotBlank(message="Object's name cannot be blank")
    private String objectName;

    @NotBlank(message="Bucket's name cannot be blank")
    private String bucketName;
}
