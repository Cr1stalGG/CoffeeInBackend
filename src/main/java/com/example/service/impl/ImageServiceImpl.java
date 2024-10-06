package com.example.service.impl;

import com.example.dto.image.ImageCreationDto;
import com.example.dto.image.ImageDto;
import com.example.dto.mapper.ImageDtoMapper;
import com.example.entity.Image;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.ImageRepository;
import com.example.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;

    @Override
    public List<ImageDto> findAll(){
        return imageRepository.findAll().stream()
                .map(ImageDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public ImageDto findById(UUID uuid){
        Image image = imageRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return ImageDtoMapper.convertEntityToDto(image);
    }

    @Override
    public ImageDto save(ImageCreationDto creationDto){
        Image image = ImageDtoMapper.convertDtoToEntity(creationDto);
        imageRepository.save(image);
        return ImageDtoMapper.convertEntityToDto(image);
    }

    @Override
    public void deleteById(UUID uuid){
        Image image = imageRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        imageRepository.deleteById(uuid);
    }
}
