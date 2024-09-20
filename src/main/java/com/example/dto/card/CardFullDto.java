package com.example.dto.card;

import com.example.entity.Transaction;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardFullDto {
    private UUID id;
    private String number;
    private String password;
    private String cvv;
    private List<Transaction> transactions;
}
