package com.example.service.impl;

import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import com.example.dto.mapper.ItemDtoMapper;
import com.example.entity.Category;
import com.example.entity.Item;
import com.example.exception.CategoryWithIdNotFoundException;
import com.example.exception.ItemWithIdNotFoundException;
import com.example.repository.CategoryRepository;
import com.example.repository.ItemRepository;
import com.example.service.ItemService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ItemServiceImpl implements ItemService{

    private final ItemRepository itemRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public List<ItemDto> findAll(){
        return itemRepository.findAll().stream()
                .map(ItemDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public ItemDto findById(UUID uuid){
        Item item  = itemRepository.findById(uuid)
                .orElseThrow(() -> new ItemWithIdNotFoundException(uuid));
        return ItemDtoMapper.convertEntityToDto(item);
    }

    @Transactional
    @Override
    public ItemDto save(UUID categoryId, ItemCreationDto creationDto){
        Optional<Category> category = categoryRepository.findById(categoryId);
        if(category.isPresent()){
            Item item = ItemDtoMapper.convertDtoToEntity(creationDto);
            item.setCategory(category.get());
            itemRepository.save(item);
            category.get().getItems().add(item);
            categoryRepository.save(category.get());
            return ItemDtoMapper.convertEntityToDto(item);
        }
        else{
            throw new CategoryWithIdNotFoundException(categoryId);
        }
    }

    @Override
    public void deleteById(UUID uuid){
        Item item = itemRepository.findById(uuid)
                .orElseThrow(() -> new ItemWithIdNotFoundException(uuid));
        itemRepository.deleteById(uuid);
    }
}
