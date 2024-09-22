package com.example.dto.card;

import com.example.dto.transaction.TransactionDto;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDto {
    private UUID id;
    private String number;
    private List<TransactionDto> transactions;
}
