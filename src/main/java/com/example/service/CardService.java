package com.example.service;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.transaction.TransactionDto;

import java.util.List;
import java.util.UUID;

public interface CardService {
    List<CardDto> findByAccountId(UUID accountId);
    CardDto findById(UUID uuid);
    CardDto save(UUID accountId, CardCreationDto creationDto);
    TransactionDto pay(UUID cardId, UUID orderId, TransactionDto creationDto);
    void deleteById(UUID uuid);
}
