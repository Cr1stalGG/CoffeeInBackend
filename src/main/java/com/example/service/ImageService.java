package com.example.service;

import com.example.dto.image.ImageCreationDto;
import com.example.dto.image.ImageDto;
import java.util.List;
import java.util.UUID;

public interface ImageService {
    List<ImageDto> findAll();
    ImageDto findById(UUID uuid);
    ImageDto save(ImageCreationDto creationDto);
    void deleteById(UUID uuid);
}
