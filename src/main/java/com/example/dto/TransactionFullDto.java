package com.example.dto;

import com.example.entity.Card;
import com.example.entity.Order;
import java.sql.Date;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionFullDto {
    private UUID id;
    private Date timeOfTransaction;
    private Card card;
    private Order order;
}
