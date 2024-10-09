package com.example.exception;

import java.util.UUID;

public class OrderStatusWithIdNotFoundException extends  RuntimeException{
    public OrderStatusWithIdNotFoundException(UUID uuid){
        super(String.format("Order Status with id %s not found", uuid));
    }
}
