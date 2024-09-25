package com.example.repository

import com.example.entity.OrderStatus
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface OrderStatusRepository: JpaRepository<OrderStatus, UUID> {
    fun findByName(name: String): Optional<OrderStatus>
}