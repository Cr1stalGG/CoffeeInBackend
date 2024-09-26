package com.example.dto.image;

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
    private String objectName;
    private String bucketName;
}
