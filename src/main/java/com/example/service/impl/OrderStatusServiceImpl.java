package com.example.service.impl;

import com.example.dto.mapper.OrderStatusDtoMapper;
import com.example.dto.order_status.OrderStatusDto;
import com.example.entity.Order;
import com.example.entity.OrderStatus;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.OrderRepository;
import com.example.repository.OrderStatusRepository;
import com.example.service.OrderStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
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
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return OrderStatusDtoMapper.convertEntityToDto(orderStatus);
    }

    @Override
    public OrderStatusDto save(UUID orderId, OrderStatusDto orderStatusDto){
        Optional<Order> order = orderRepository.findById(orderId);
        if(order.isPresent()){
            OrderStatus orderStatus = OrderStatusDtoMapper.convertDtoToEntity(orderStatusDto);
            orderStatus.getOrders().add(order.get());
            order.get().setOrderStatus(orderStatus);
            orderStatusRepository.save(orderStatus);
            orderRepository.save(order.get());
            return OrderStatusDtoMapper.convertEntityToDto(orderStatus);
        }
        else{
            throw new AccountWithIdNotFoundException(orderId);
        }
    }

    @Override
    public void deleteById(UUID uuid){
        OrderStatus orderStatus = orderStatusRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        orderStatusRepository.deleteById(uuid);
    }
}
