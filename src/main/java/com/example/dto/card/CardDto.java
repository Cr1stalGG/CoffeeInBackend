package com.example.dto.card;

import java.util.List;
import java.util.UUID;
import com.example.dto.transaction.TransactionDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private UUID uuid;
    private String number;
    private List<TransactionDto> transactions;
}
