package com.example.exception;

import java.util.UUID;

public class RoleWithIdNotFoundException extends RuntimeException{
    public RoleWithIdNotFoundException(UUID uuid){
        super(String.format("Role with id %s not found", uuid));
    }
}
