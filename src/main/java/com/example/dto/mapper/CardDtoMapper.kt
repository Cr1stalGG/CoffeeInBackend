package com.example.dto.mapper

import com.example.dto.card.CardDto
import com.example.dto.transaction.TransactionDto
import com.example.entity.Card
import com.example.entity.Transaction

object CardDtoMapper {
    fun convertEntityToDto(source: Card): CardDto{
        return CardDto(
            uuid = source.id,
            number = source.number,
            transactions = buildTransactions(source.transactions)
        )
    }

    private fun buildTransactions(source: List<Transaction>?): List<TransactionDto>? {
        return source?.stream()!!
            .map(TransactionDtoMapper::convertEntityToDto)
            .toList() ?: ArrayList()
    }
}