package com.example.dto.mapper;

import com.example.dto.item.ItemDto;
import com.example.dto.order.OrderDto;
import com.example.entity.Item;
import com.example.entity.Order;
import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class OrderDtoMapper {
    public static OrderDto convertEntityToDto(Order source) {
        return Optional.ofNullable(source)
                .map(OrderDtoMapper::buildDto)
                .orElse(null);
    }

    private static OrderDto buildDto(Order source){
        return OrderDto.builder()
                .uuid(source.getId())
                .closingTime(source.getCosingTime())
                .items(buildItems(source.getItems()))
                .summaryPrice(source.getSummaryPrice())
                .build();
    }

    private static List<ItemDto> buildItems(List<Item> source){
        if(source == null)
            return new ArrayList<>();
        else
            return source.stream()
                    .map(ItemDtoMapper::convertEntityToDto)
                    .toList();
    }
}
