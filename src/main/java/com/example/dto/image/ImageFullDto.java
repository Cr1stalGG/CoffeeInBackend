package com.example.dto.image;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageFullDto {
    private UUID id;
    private String objectName;
    private String bucketName;
}
