package com.example.service.impl;

import com.example.dto.mapper.OrderDtoMapper;
import com.example.dto.mapper.TransactionDtoMapper;
import com.example.dto.order.OrderCreationDto;
import com.example.dto.order.OrderDto;
import com.example.dto.transaction.TransactionDto;
import com.example.entity.*;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.exception.OrderWithIdNotFoundException;
import com.example.repository.*;
import com.example.service.OrderService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final AccountRepository accountRepository;
    private final CardRepository cardRepository;
    private final TransactionRepository transactionRepository;
    private final OrderStatusRepository orderStatusRepository;
    private final ItemRepository itemRepository;

    @Override
    public List<OrderDto> findAll(){
        return orderRepository.findAll().stream()
                .map(OrderDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public OrderDto findById(UUID uuid){
        Order order = orderRepository.findById(uuid)
                .orElseThrow(() -> new OrderWithIdNotFoundException(uuid));
        return OrderDtoMapper.convertEntityToDto(order);
    }

    @Transactional
    @Override
    public OrderDto save(UUID accountId, UUID orderStatusId, OrderCreationDto creationDto){
        Optional<Account> account = accountRepository.findById(accountId);
        Optional<OrderStatus> orderStatus = orderStatusRepository.findById(orderStatusId);
        if(account.isPresent() && orderStatus.isPresent()){
            Order order = Order.builder()
                    .closingTime((java.sql.Date) new Date())
                            .build();
            if (creationDto.getItemsId() != null) {
                List<Item> items = itemRepository.findAllById(creationDto.getItemsId());
                order.setItems(items);
            }
            order.setOrderStatus(orderStatus.get());
            order.setOwner(account.get());
            orderRepository.save(order);
            account.get().getOrders().add(order);
            accountRepository.save(account.get());
            return OrderDtoMapper.convertEntityToDto(order);
        }
        else{
            throw new AccountWithIdNotFoundException(accountId);
        }
    }

    @Override
    @Transactional
    public TransactionDto pay(UUID cardId, UUID orderId, TransactionDto creationDto){
        Optional<Card> card = cardRepository.findById(cardId);
        Optional<Order> order = orderRepository.findById(orderId);
        if(card.isPresent() && order.isPresent() && card.get().getMoney() >= order.get().getSummaryPrice()){
            card.get().setMoney(card.get().getMoney() - order.get().getSummaryPrice());
            Transaction transaction = Transaction.builder()
                    .timeOfTransaction((java.sql.Date) new Date())
                    .card(card.get())
                    .order(order.get())
                    .build();
            cardRepository.save(card.get());
            transactionRepository.save(transaction);
            return TransactionDtoMapper.convertEntityToDto(transaction);
        }else{
            if (!card.isPresent()) {
                throw new AccountWithIdNotFoundException(cardId);
            } else {
                throw new AccountWithIdNotFoundException(orderId);
            }
        }
    }
    @Override
    public void deleteById(UUID uuid){
        Order order = orderRepository.findById(uuid)
                .orElseThrow(() -> new OrderWithIdNotFoundException(uuid));
        orderRepository.deleteById(uuid);
    }
}
