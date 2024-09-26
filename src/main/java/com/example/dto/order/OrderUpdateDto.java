package com.example.dto.order;

import com.example.dto.item.ItemFullDto;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderUpdateDto {
    private Date closingTime;
    private List<ItemFullDto> items;
}
