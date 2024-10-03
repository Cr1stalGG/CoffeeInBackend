package com.example.dto.mapper;

import com.example.dto.transaction.TransactionDto;
import com.example.entity.Transaction;
import lombok.experimental.UtilityClass;
import java.util.Optional;

@UtilityClass
public class TransactionDtoMapper {
    public static TransactionDto convertEntityToDto(Transaction source) {
        return Optional.ofNullable(source)
                .map(TransactionDtoMapper::buildDto)
                .orElse(null);
    }

    private static TransactionDto buildDto(Transaction source) {
        return TransactionDto.builder()
                .uuid(source.getId())
                .timeOfTransaction(source.getTimeOfTransaction())
                .order(OrderDtoMapper.convertEntityToDto(source.getOrder()))
                .build();
    }
}
