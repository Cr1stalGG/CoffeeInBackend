package com.example.controllers;

import com.example.dto.image.ImageCreationDto;
import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import com.example.dto.item.ItemUpdateDto;
import com.example.service.ItemService;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/items")
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemDto> findById(@PathVariable("id") UUID id) {
        ItemDto item = itemService.findById(id);
        return ResponseEntity.ok(item);
    }

    @GetMapping
    @Cacheable(value = "items")
    public ResponseEntity<List<ItemDto>> findAll() {
        List<ItemDto> items = itemService.findAll();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/{categoryId}")
    @CacheEvict(value = "items", allEntries = true)
    public ResponseEntity<ItemDto> save(
            @PathVariable("categoryId") UUID categoryId,
            @RequestBody ItemCreationDto creationDto) {
        ItemDto item = itemService.save(categoryId, creationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "items", key = "#id", allEntries = true)
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") UUID id, @RequestBody ItemUpdateDto updateDto) {
        ItemDto item = itemService.updateItem(id, updateDto);
        return ResponseEntity.ok(item);
    }

    @PutMapping("/{id}/image")
    @CacheEvict(value = "items", key = "#id", allEntries = true)
    public ResponseEntity<ItemDto> setImage(@PathVariable("id") UUID id, @RequestBody ImageCreationDto imageDto) {
        ItemDto item = itemService.setImage(id, imageDto);
        return ResponseEntity.ok(item);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "items", key = "#id", allEntries = true)
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
