package com.example.exception;

public class OrderStatusWithNameNotFoundException extends RuntimeException {
    public OrderStatusWithNameNotFoundException(String newOrderStatusName) {
        super("Order status with name '" + newOrderStatusName + "' not found");
    }
}
