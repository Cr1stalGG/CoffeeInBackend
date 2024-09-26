package com.example.service

import com.example.dto.card.CardCreationDto
import com.example.dto.card.CardDto
import com.example.dto.transaction.TransactionDto
import java.util.*

interface CardService {
    fun findById(id: UUID): CardDto
    fun findByAccountId(accountId: UUID): List<CardDto>
    fun addCard(accountId: UUID, creationDto: CardCreationDto): CardDto
    fun pay(cardId: UUID, orderId: UUID): TransactionDto
    fun deleteById(id: UUID)
}