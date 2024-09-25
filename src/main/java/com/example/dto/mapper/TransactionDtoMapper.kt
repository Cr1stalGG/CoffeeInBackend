package com.example.dto.mapper

import com.example.dto.transaction.TransactionDto
import com.example.entity.Transaction

object TransactionDtoMapper {
    fun convertEntityToDto(source: Transaction): TransactionDto{
        return TransactionDto(
            uuid = source.id,
            timeOfTransaction = source.timeOfTransaction,
            order = OrderDtoMapper.convertEntityToDto(source.order)
        )
    }
}