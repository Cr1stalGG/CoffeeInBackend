package com.example.dto.transaction;

import java.sql.Date;
import java.util.UUID;
import com.example.dto.order.OrderDto;

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
public class TransactionDto {
    private UUID uuid;
    private Date timeOfTransaction;
    private OrderDto order;
}
