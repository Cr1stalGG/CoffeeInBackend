package com.example.service

import com.example.dto.order.OrderCreationDto
import com.example.dto.order.OrderDto
import java.util.UUID

interface OrderService {
    fun findById(id: UUID): OrderDto
    fun addOrder(accountId: UUID, orderCreationDto: OrderCreationDto): OrderDto
    fun deleteById(id: UUID)
}