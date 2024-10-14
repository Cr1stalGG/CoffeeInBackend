package com.example.service;

import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import com.example.dto.item.ItemUpdateDto;

import java.util.List;
import java.util.UUID;

public interface ItemService {
    List<ItemDto> findAll();
    ItemDto findById(UUID uuid);
    ItemDto save(UUID categoryId, ItemCreationDto creationDto);
    ItemDto updateItem(UUID itemId, ItemUpdateDto updateDto);
    void deleteById(UUID uuid);
}
