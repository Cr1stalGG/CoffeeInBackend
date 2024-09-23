package com.example.dto.mapper

import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.entity.Item
import lombok.experimental.UtilityClass

@UtilityClass
class ItemDtoMapper {
    companion object {
        fun convertEntityToDto(source: Item): ItemDto {
            return ItemDto(
                uuid = source.id,
                name = source.name,
                description = source.description,
                price = source.price,
                category = CategoryDtoMapper.convertEntityToDto(source.category),
                image = ImageDtoMapper.convertEntityToDto(source.image)
            )
        }

        fun convertDtoToEntity(source: ItemCreationDto): Item {
            return Item(
                source.name,
                source.description,
                source.price
            )
        }
    }
}