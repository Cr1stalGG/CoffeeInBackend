package com.example.dto.mapper

import com.example.dto.order_status.OrderStatusDto
import com.example.entity.OrderStatus

object OrderStatusDtoMapper {
    fun convertEntityToDto(source: OrderStatus): OrderStatusDto {
        return OrderStatusDto(
            uuid = source.id,
            name = source.name,
            description = source.description
        )
    }
}