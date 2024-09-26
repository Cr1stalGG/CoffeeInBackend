package com.example.dto.order_status;

import java.util.UUID;

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
public class OrderStatusDto {
    private UUID id;
    private String name;
    private String description;
}
