package com.example.dto.mapper

import com.example.dto.image.ImageDto
import com.example.entity.Image
import lombok.experimental.UtilityClass

@UtilityClass
class ImageDtoMapper {
    companion object {
        fun convertEntityToDto(source: Image): ImageDto {
            return ImageDto(
                uuid = source.id,
                bucketName = source.bucketName,
                objectName = source.objectName
            )
        }
    }
}