package com.example.service;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import java.util.List;
import java.util.UUID;

public interface CardService {
    List<CardDto> findAll();
    CardDto findById(UUID uuid);
    CardDto save(UUID accountId, CardCreationDto creationDto);
    void deleteById(UUID uuid);
}
