package com.example.dto.mapper

import com.example.dto.transaction.TransactionDto
import com.example.entity.Transaction
import lombok.experimental.UtilityClass

@UtilityClass
class TransactionDtoMapper {
    companion object{
        fun convertEntityToDto(source: Transaction): TransactionDto{
            return TransactionDto(
                uuid = source.id,
                timeOfTransaction = source.timeOfTransaction,
                order = OrderDtoMapper.convertEntityToDto(source.order)
            )
        }
    }
}