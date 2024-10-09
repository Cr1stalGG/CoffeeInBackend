package com.example.service.impl;

import com.example.dto.mapper.OrderStatusDtoMapper;
import com.example.dto.order_status.OrderStatusDto;
import com.example.entity.OrderStatus;
import com.example.exception.OrderStatusWithIdNotFoundException;
import com.example.repository.OrderRepository;
import com.example.repository.OrderStatusRepository;
import com.example.service.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderStatusServiceImpl implements OrderStatusService{

    private final OrderStatusRepository orderStatusRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<OrderStatusDto> findAll(){
        return orderStatusRepository.findAll().stream()
                .map(OrderStatusDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public OrderStatusDto findById(UUID uuid){
        OrderStatus orderStatus = orderStatusRepository.findById(uuid)
                .orElseThrow(() -> new OrderStatusWithIdNotFoundException(uuid));
        return OrderStatusDtoMapper.convertEntityToDto(orderStatus);
    }


    @Override
    public void deleteById(UUID uuid){
        OrderStatus orderStatus = orderStatusRepository.findById(uuid)
                .orElseThrow(() -> new OrderStatusWithIdNotFoundException(uuid));
        orderStatusRepository.deleteById(uuid);
    }
}
