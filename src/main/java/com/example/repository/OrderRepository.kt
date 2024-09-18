package com.example.repository

import com.example.entity.Order
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OrderRepository: JpaRepository<Order, UUID>