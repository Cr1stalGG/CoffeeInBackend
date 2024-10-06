package com.example.service;

import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import java.util.List;
import java.util.UUID;

public interface ItemService {
    List<ItemDto> findAll();
    ItemDto findById(UUID uuid);
    ItemDto save(UUID categoryId, ItemCreationDto creationDto);
    void deleteById(UUID uuid);
}
