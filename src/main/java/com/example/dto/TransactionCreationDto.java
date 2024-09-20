package com.example.dto;

import com.example.entity.Card;
import com.example.entity.Order;
import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionCreationDto {
    private Date timeOfTransaction;
    private Card card;
    private Order order;
}
