package com.example.dto.order;

import com.example.dto.account.AccountFullDto;
import com.example.dto.item.ItemFullDto;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderFullDto {
    private UUID id;
    private Date closingTime;
    private AccountFullDto owner;
    private List<ItemFullDto> items;
}
