package com.example.dto.mapper;

import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import com.example.entity.Item;
import lombok.experimental.UtilityClass;
import java.util.Optional;

@UtilityClass
public class ItemDtoMapper {
    public static ItemDto convertEntityToDto(Item source) {
        return Optional.ofNullable(source)
                .map(ItemDtoMapper::buildDto)
                .orElse(null);
    }

    public static Item convertDtoToEntity(ItemCreationDto source){
        return Optional.ofNullable(source)
                .map(ItemDtoMapper::buildEntity)
                .orElse(null);
    }

    private static ItemDto buildDto(Item source){
        return ItemDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .price(source.getPrice())
                .category(CategoryDtoMapper.convertEntityToDto(source.getCategory()))
                .image(ImageDtoMapper.convertEntityToDto(source.getImage()))
                .build();
    }

    private static Item buildEntity(ItemCreationDto source){
        return Item.builder()
                .name(source.getName())
                .description(source.getDescription())
                .price(source.getPrice())
                .build();
    }
}
