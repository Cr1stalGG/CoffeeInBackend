package com.example.dto.mapper;

import com.example.dto.image.ImageCreationDto;
import com.example.dto.image.ImageDto;
import com.example.entity.Image;
import java.util.Optional;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ImageDtoMapper {
    public static ImageDto convertEntityToDto(Image source) {
        return Optional.ofNullable(source)
                .map(ImageDtoMapper::buildDto)
                .orElse(null);
    }

    public static Image convertDtoToEntity(ImageCreationDto source){
        return Optional.ofNullable(source)
                .map(ImageDtoMapper::buildEntity)
                .orElse(null);
    }

    private static ImageDto buildDto(Image source){
        return ImageDto.builder()
                .uuid(source.getId())
                .objectName(source.getObjectName())
                .bucketName(source.getBucketName())
                .build();
    }

    private static Image buildEntity(ImageCreationDto source){
        return Image.builder()
                .objectName(source.getObjectName())
                .bucketName(source.getBucketName())
                .build();
    }
}
