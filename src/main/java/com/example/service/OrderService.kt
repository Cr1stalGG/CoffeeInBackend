package com.example.service

import com.example.dto.order.OrderCreationDto
import com.example.dto.order.OrderDto
import java.util.*

interface OrderService {
    fun findById(id: UUID): OrderDto
    fun addOrder(accountId: UUID, orderCreationDto: OrderCreationDto): OrderDto
    fun changeOrderStatus(orderId: UUID): OrderDto
    fun deleteById(id: UUID)
}