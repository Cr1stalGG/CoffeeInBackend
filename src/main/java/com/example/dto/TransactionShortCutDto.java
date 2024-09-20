package com.example.dto;

import com.example.entity.Card;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionShortCutDto {
    private UUID id;
    private Card card;
}
