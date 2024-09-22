package com.example.dto.transaction;

import com.example.dto.order.OrderDto;
import java.sql.Date;
import java.util.UUID;
import lombok.*;

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
