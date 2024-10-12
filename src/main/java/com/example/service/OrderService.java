package com.example.service;

import com.example.dto.order.OrderCreationDto;
import com.example.dto.order.OrderDto;
import com.example.dto.transaction.TransactionDto;

import java.util.List;
import java.util.UUID;

public interface OrderService {
    OrderDto findById(UUID uuid);
    OrderDto save(UUID accountId, UUID orderStatusId, OrderCreationDto creationDto);
    void deleteById(UUID uuid);
}
