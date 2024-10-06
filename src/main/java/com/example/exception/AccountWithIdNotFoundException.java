package com.example.exception;

import java.util.UUID;

public class AccountWithIdNotFoundException extends RuntimeException {
    public AccountWithIdNotFoundException(UUID uuid) {
        super(String.format("Account with id %s not found", uuid));
    }
}


