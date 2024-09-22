package com.example.dto.image;

import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ImageDto {
    private UUID id;
    private String objectName;
    private String bucketName;
}
