package com.example.controller

import com.example.dto.order.OrderCreationDto
import com.example.dto.order.OrderDto
import com.example.service.OrderService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/orders")
class OrderController(
    private val orderService: OrderService,
) {
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): OrderDto {
        return orderService.findById(id)
    }

    @PostMapping("/{accountId}")
    fun addOrder(@PathVariable("accountId") id: UUID, @RequestBody creationDto: OrderCreationDto): OrderDto {
        return orderService.addOrder(id, creationDto)
    }

    @PutMapping("/{orderId}/status")
    fun changeOrderStatusToNext(@PathVariable("orderId") orderId: UUID): OrderDto{
        return orderService.changeOrderStatus(orderId)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID) {
        orderService.deleteById(id)
    }

}