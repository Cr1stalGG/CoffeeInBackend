package com.example.dto;

import com.example.entity.Card;
import com.example.entity.Order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionUpdateDto {
    private Card card;
    private Order order;
}
