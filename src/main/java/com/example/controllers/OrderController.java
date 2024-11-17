package com.example.controllers;

import com.example.dto.order.OrderCreationDto;
import com.example.dto.order.OrderDto;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.exception.OrderStatusWithIdNotFoundException;
import com.example.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> findById(@PathVariable("id") UUID id) {
        OrderDto order = orderService.findById(id);
        return ResponseEntity.ok(order);
    }

    @PostMapping("/{accountId}/{orderStatusId}")
    public ResponseEntity<OrderDto> addOrder( @PathVariable("accountId") UUID accountId, @PathVariable("orderStatusId") UUID orderStatusId, @RequestBody OrderCreationDto creationDto) {
        try {
            OrderDto order = orderService.save(accountId, orderStatusId, creationDto);

            return ResponseEntity.status(HttpStatus.CREATED).body(order);
        }
    catch (AccountWithIdNotFoundException |
           OrderStatusWithIdNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e)
        {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }


    @PutMapping("/{orderId}/status")
    public OrderDto changeOrderStatusToNext(@PathVariable("orderId") UUID orderId) {
        return orderService.changeOrderStatus(orderId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        orderService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
