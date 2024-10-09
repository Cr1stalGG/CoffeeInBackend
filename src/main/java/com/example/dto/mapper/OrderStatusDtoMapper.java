package com.example.dto.mapper;

import com.example.dto.order_status.OrderStatusDto;
import com.example.entity.OrderStatus;
import lombok.experimental.UtilityClass;
import java.util.Optional;

@UtilityClass
public class OrderStatusDtoMapper {
    public static OrderStatusDto convertEntityToDto(OrderStatus source) {
        return Optional.ofNullable(source)
                .map(OrderStatusDtoMapper::buildDto)
                .orElse(null);
    }

    private static OrderStatusDto buildDto(OrderStatus source){
        return OrderStatusDto.builder()
                .uuid(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();
    }
}
