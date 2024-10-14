package com.example.exception;

import java.util.UUID;

public class ItemWithIdNotFoundException extends  RuntimeException{
    public ItemWithIdNotFoundException(UUID uuid){
        super(String.format("Item with id '%s' not found", uuid));
    }
}
