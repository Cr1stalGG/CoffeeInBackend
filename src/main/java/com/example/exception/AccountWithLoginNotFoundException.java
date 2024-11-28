package com.example.exception;

public class AccountWithLoginNotFoundException extends RuntimeException{
    public AccountWithLoginNotFoundException(String login) {
        super(String.format("Account with login '%s' not found", login));
    }
}
