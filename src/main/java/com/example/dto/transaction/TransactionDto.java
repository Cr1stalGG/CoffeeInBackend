package com.example.dto.transaction;

import com.example.dto.order.OrderDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.sql.Date;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDto {
    private UUID id;
    private Date timeOfTransaction;
    private OrderDto order;
}
