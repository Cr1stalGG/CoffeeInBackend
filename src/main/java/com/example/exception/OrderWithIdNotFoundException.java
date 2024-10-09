package com.example.exception;

import java.util.UUID;

public class OrderWithIdNotFoundException extends  RuntimeException{
    public OrderWithIdNotFoundException(UUID uuid){
        super(String.format("Order with id %s not found", uuid));
    }
}
