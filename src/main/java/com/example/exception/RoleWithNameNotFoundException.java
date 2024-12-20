package com.example.exception;

public class RoleWithNameNotFoundException extends RuntimeException {
    public RoleWithNameNotFoundException(String name) {
        super(String.format("Role with name '%s' not found", name));
    }
}
