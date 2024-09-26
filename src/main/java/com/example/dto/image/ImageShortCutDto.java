package com.example.dto.image;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImageShortCutDto {
    private UUID id;
    private String objectName;
}
