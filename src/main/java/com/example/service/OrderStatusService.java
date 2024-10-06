package com.example.service;

import com.example.dto.order_status.OrderStatusDto;
import com.example.entity.OrderStatus;
import java.util.List;
import java.util.UUID;

public interface OrderStatusService {
    List<OrderStatusDto> findAll();
    OrderStatusDto findById(UUID uuid);
    OrderStatusDto save(UUID orderId, OrderStatusDto orderStatusDto);
    void deleteById(UUID uuid);
}
