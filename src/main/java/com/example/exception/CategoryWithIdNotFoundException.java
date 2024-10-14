package com.example.exception;

import java.util.UUID;

public class CategoryWithIdNotFoundException extends  RuntimeException{
    public CategoryWithIdNotFoundException(UUID uuid){
        super(String.format("Category with id '%s' not found", uuid));
    }
}
