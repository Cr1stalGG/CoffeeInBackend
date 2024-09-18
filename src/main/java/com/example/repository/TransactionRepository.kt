package com.example.repository

import com.example.entity.Transaction
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface TransactionRepository: JpaRepository<Transaction, UUID> {
    fun findByCard_Number(number: String): List<Transaction?>
}