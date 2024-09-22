package com.example.dto.order;

import com.example.dto.item.ItemDto;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto {
    private UUID id;
    private Date closingTime;
    private List<ItemDto> items;
}
