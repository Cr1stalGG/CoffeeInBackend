package com.example.dto.order;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import com.example.dto.item.ItemDto;

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
public class OrderDto {
    private UUID uuid;
    private Date closingTime;
    private List<ItemDto> items;
    private Double summaryPrice;
}
