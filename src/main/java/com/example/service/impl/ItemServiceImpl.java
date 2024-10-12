package com.example.service.impl;

import com.example.dto.item.ItemCreationDto;
import com.example.dto.item.ItemDto;
import com.example.dto.item.ItemUpdateDto;
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
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;
import java.util.List;
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
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new CategoryWithIdNotFoundException(categoryId));

            Item item = ItemDtoMapper.convertDtoToEntity(creationDto);

            item.setCategory(category);
            itemRepository.save(item);

            category.getItems().add(item);

            return ItemDtoMapper.convertEntityToDto(item);
    }

    @Transactional
    @Override
    public ItemDto updateItem(UUID itemId, @NotNull ItemUpdateDto updateDto){
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new ItemWithIdNotFoundException(itemId));

        if(!updateDto.getName().isEmpty()){
            item.setName(updateDto.getName());
        }

        if(!updateDto.getDescription().isEmpty()){
            item.setDescription(updateDto.getDescription());
        }

        if(updateDto.getPrice() != null){
            item.setPrice(updateDto.getPrice());
        }

        if(updateDto.getCategoryId() != null){
            Category category = categoryRepository.findById(updateDto.getCategoryId())
                    .orElseThrow(()-> new CategoryWithIdNotFoundException(updateDto.getCategoryId()));

            item.setCategory(category);
        }

        return ItemDtoMapper.convertEntityToDto(item);
    }

    @Override
    public void deleteById(UUID uuid){
        Item item = itemRepository.findById(uuid)
                .orElseThrow(() -> new ItemWithIdNotFoundException(uuid));

        itemRepository.deleteById(uuid);
    }
}
