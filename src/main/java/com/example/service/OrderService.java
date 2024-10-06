package com.example.service;

import com.example.dto.order.OrderCreationDto;
import com.example.dto.order.OrderDto;
import com.example.dto.transaction.TransactionDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    List<OrderDto> findAll();
    OrderDto findById(UUID uuid);
    OrderDto save(UUID accountId, OrderCreationDto creationDto);
    TransactionDto pay(UUID cardId, UUID orderId, TransactionDto creationDto);
    void deleteById(UUID uuid);
}
