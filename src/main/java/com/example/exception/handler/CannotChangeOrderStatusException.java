package com.example.exception.handler;

public class CannotChangeOrderStatusException extends RuntimeException {
    public CannotChangeOrderStatusException(String statusName) {
        super("Cannot change order status with name " + statusName);
    }
}