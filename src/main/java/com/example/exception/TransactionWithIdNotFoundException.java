package com.example.exception;

import java.util.UUID;

public class TransactionWithIdNotFoundException extends RuntimeException{
    public TransactionWithIdNotFoundException(UUID uuid){
        super(String.format("Transaction with id %s not found", uuid));
    }
}
