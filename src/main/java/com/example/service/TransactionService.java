package com.example.service;

import com.example.dto.transaction.TransactionDto;
import java.util.List;
import java.util.UUID;

public interface TransactionService {
    List<TransactionDto> findAll();
    TransactionDto findById(UUID uuid);
    void deleteById(UUID uuid);
}
