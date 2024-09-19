package com.example.dto.mapper

import com.example.dto.item.ItemDto
import com.example.dto.order.OrderDto
import com.example.entity.Item
import com.example.entity.Order
import lombok.experimental.UtilityClass

@UtilityClass
class OrderDtoMapper {
    companion object{
        fun convertEntityToDto(source: Order): OrderDto{
            return OrderDto(
                uuid = source.id,
                closingTime = source.closingTime,
                items = buildItems(source.items)
            )
        }

        private fun buildItems(source: List<Item>?): List<ItemDto> {
            return source?.stream()!!
                .map(ItemDtoMapper::convertEntityToDto)
                .toList() ?: ArrayList()
        }
    }
}