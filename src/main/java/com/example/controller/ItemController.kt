package com.example.controller

import com.example.dto.image.ImageCreationDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.dto.item.ItemUpdateDto
import com.example.service.ItemService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/items")
class ItemController(
    private val itemService: ItemService,
) {
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): ItemDto {
        return itemService.findById(id)
    }

    @GetMapping
    @Cacheable(value = ["items"])
    fun findAll(): List<ItemDto> {
        return itemService.findAll()
    }

    @PostMapping
    @CacheEvict(value = ["items"], allEntries = true)
    fun save(@RequestBody creationDto: ItemCreationDto): ItemDto {
        return itemService.save(creationDto)
    }

    @PutMapping("/{id}")
    @CacheEvict(value = ["items"], key = "#id", allEntries = true)
    fun updateItem(@PathVariable("id") id: UUID, @RequestBody updateDto: ItemUpdateDto): ItemDto {
        return itemService.updateItem(id, updateDto)
    }

    @PutMapping("/{id}/image")
    @CacheEvict(value = ["items"], key = "#id", allEntries = true)
    fun setImage(@PathVariable("id") id: UUID, @RequestBody imageDto: ImageCreationDto): ItemDto {
        return itemService.setImage(id, imageDto)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["items"], key = "#id", allEntries = true)
    fun deleteById(@PathVariable("id") id: UUID){
        itemService.deleteById(id)
    }
}