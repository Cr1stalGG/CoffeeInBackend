package com.example.service

import com.example.dto.card.CardDto
import java.util.*

interface CardService {
    fun findById(id: UUID): CardDto
    fun findByAccountId(accountId: UUID): List<CardDto>
//    fun addCard(accountId: UUID, creationDto: CardCreationDto): CardDto
//    fun pay(cardId: UUID, orderId: UUID): PaymentDto
    fun deleteById(id: UUID)
}