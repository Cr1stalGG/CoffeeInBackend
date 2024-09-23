package com.example.service.impl

import com.example.dto.image.ImageCreationDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.dto.item.ItemUpdateDto
import com.example.dto.mapper.ImageDtoMapper
import com.example.dto.mapper.ItemDtoMapper
import com.example.entity.Category
import com.example.entity.Image
import com.example.entity.Item
import com.example.exception.CategoryWithIdNotFoundException
import com.example.exception.ItemWithIdNotFoundException
import com.example.repository.CategoryRepository
import com.example.repository.ImageRepository
import com.example.repository.ItemRepository
import com.example.service.ItemService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class ItemServiceImpl(
    val itemRepository: ItemRepository,
    val categoryRepository: CategoryRepository,
    val imageRepository: ImageRepository,
) : ItemService {
    override fun findById(id: UUID): ItemDto {
        val item: Item = itemRepository.findById(id)
            .orElseThrow{ ItemWithIdNotFoundException(id) }

        return ItemDtoMapper.convertEntityToDto(item)
    }

    override fun findAll(): List<ItemDto> {
        return itemRepository.findAll().stream()
            .map(ItemDtoMapper::convertEntityToDto)
            .toList()
    }

    @Transactional
    override fun save(creationDto: ItemCreationDto): ItemDto {
        val category: Category = categoryRepository.findById(creationDto.categoryId)
            .orElseThrow{ CategoryWithIdNotFoundException(creationDto.categoryId) }

        val item: Item = ItemDtoMapper.convertDtoToEntity(creationDto)

        item.category = category

        itemRepository.save(item)

        return ItemDtoMapper.convertEntityToDto(item)
    }

    @Transactional
    override fun updateItem(id: UUID, updateDto: ItemUpdateDto): ItemDto {
        val item: Item = itemRepository.findById(id)
            .orElseThrow{ItemWithIdNotFoundException(id)}

        if(!updateDto.name.isNullOrEmpty())
            item.name = updateDto.name

        if(!updateDto.description.isNullOrEmpty())
            item.description = updateDto.description

        if(updateDto.categoryId != null){
            val category: Category = categoryRepository.findById(updateDto.categoryId)
                .orElseThrow{CategoryWithIdNotFoundException(id)}

            item.category = category
        }

        return ItemDtoMapper.convertEntityToDto(item)
    }

    @Transactional
    override fun setImage(id: UUID, imageDto: ImageCreationDto): ItemDto {
        val image: Image = ImageDtoMapper.convertDtoToEntity(imageDto)
        val item: Item = itemRepository.findById(id)
            .orElseThrow{ItemWithIdNotFoundException(id)}

        imageRepository.save(image)

        item.image = image

        return ItemDtoMapper.convertEntityToDto(item)
    }

    override fun deleteById(id: UUID) {
        itemRepository.findById(id)
            .orElseThrow{ItemWithIdNotFoundException(id)}

        itemRepository.deleteById(id)
    }
}