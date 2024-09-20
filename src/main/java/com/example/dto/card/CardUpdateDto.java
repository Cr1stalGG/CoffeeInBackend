package com.example.dto.card;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardUpdateDto {
    private String number;
    private String password;
    private String cvv;
}
