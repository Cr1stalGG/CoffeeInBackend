package com.example.repository

import com.example.entity.Card
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface CardRepository: JpaRepository<Card, UUID> {
    fun findByOwner_Id(id: UUID): List<Card>
}