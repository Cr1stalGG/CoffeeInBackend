package com.example.service

import com.example.dto.image.ImageCreationDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.dto.item.ItemUpdateDto
import java.util.UUID

interface ItemService {
    fun findById(id: UUID): ItemDto
    fun findAll(): List<ItemDto>
    // todo fun filter(filterDto: ItemFilterDto): List<ItemDto>
    fun save(creationDto: ItemCreationDto): ItemDto
    fun updateItem(id: UUID, updateDto: ItemUpdateDto): ItemDto
    fun setImage(id: UUID, imageDto: ImageCreationDto): ItemDto
    fun deleteById(id: UUID)
}