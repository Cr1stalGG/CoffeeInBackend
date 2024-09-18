package com.example.dto.card

import com.example.dto.TransactionDto
import java.util.*

data class CardDto(
    val uuid: UUID,
    val number: String,
    val transactions: List<TransactionDto>,
)
