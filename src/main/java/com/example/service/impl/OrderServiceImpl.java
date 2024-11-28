package com.example.service.impl;

import com.example.dto.mapper.OrderDtoMapper;
import com.example.dto.order.OrderCreationDto;
import com.example.dto.order.OrderDto;
import com.example.entity.Account;
import com.example.entity.Item;
import com.example.entity.Order;
import com.example.entity.OrderStatus;
import com.example.exception.OrderStatusWithIdNotFoundException;
import com.example.exception.OrderStatusWithNameNotFoundException;
import com.example.exception.OrderWithIdNotFoundException;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.exception.CannotChangeOrderStatusException;
import com.example.repository.AccountRepository;
import com.example.repository.CardRepository;
import com.example.repository.OrderRepository;
import com.example.repository.TransactionRepository;
import com.example.repository.OrderStatusRepository;
import com.example.repository.ItemRepository;
import com.example.service.OrderService;
import com.example.service.enums.OrderStatusEnum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
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
    public OrderDto findById(UUID uuid){
        Order order = orderRepository.findById(uuid)
                .orElseThrow(() -> new OrderWithIdNotFoundException(uuid));

        return OrderDtoMapper.convertEntityToDto(order);
    }

    @Transactional
    @Override
    public OrderDto save(UUID accountId, UUID orderStatusId, OrderCreationDto creationDto){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountWithIdNotFoundException(accountId));

        OrderStatus orderStatus = orderStatusRepository.findById(orderStatusId)
                .orElseThrow(() -> new OrderStatusWithIdNotFoundException(orderStatusId));

        Order order = Order.builder()
                .closingTime(new Date(System.currentTimeMillis()))
                .owner(account)
                .orderStatus(orderStatus)
                .build();

        if (creationDto.getItemsId() != null) {
            List<Item> items = itemRepository.findAllById(creationDto.getItemsId());
            order.setItems(items);

            double summaryPrice = 0;
            for (Item item : items) {
                summaryPrice += item.getPrice();
            }
            order.setSummaryPrice(summaryPrice);
        }

        orderRepository.save(order);

        account.getOrders().add(order);

        return OrderDtoMapper.convertEntityToDto(order);
    }

    @Transactional
    @Override
    public OrderDto changeOrderStatus(UUID orderId) {

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderWithIdNotFoundException(orderId));

        String newOrderStatusName;
        String currentOrderStatusName = order.getOrderStatus().getName(); // Получаем строковое представление текущего статуса

        switch (currentOrderStatusName) {
            case "STATUS_TAKEN": // Сравниваем со строковыми значениями
                newOrderStatusName = OrderStatusEnum.STATUS_IN_PROGRESS.getValue(); // Получаем новое значение статуса
                break;
            case "STATUS_IN_PROGRESS":
                newOrderStatusName = OrderStatusEnum.STATUS_DONE.getValue();
                break;
            default:
                throw new CannotChangeOrderStatusException(currentOrderStatusName);
        }

        OrderStatus previousOrderStatus = order.getOrderStatus();

        OrderStatus newOrderStatus = orderStatusRepository.findByName(newOrderStatusName)
                .orElseThrow(() -> new OrderStatusWithNameNotFoundException(newOrderStatusName));

        previousOrderStatus.getOrders().remove(order);
        order.setOrderStatus(newOrderStatus);
        newOrderStatus.getOrders().add(order);

        return OrderDtoMapper.convertEntityToDto(order);
    }

    @Override
    public void deleteById(UUID uuid){
        Order order = orderRepository.findById(uuid)
                .orElseThrow(() -> new OrderWithIdNotFoundException(uuid));

        orderRepository.deleteById(uuid);
    }
}
