package com.example.exception;

import java.util.UUID;

public class CardWithIdNotFoundException extends RuntimeException {
    public CardWithIdNotFoundException(UUID uuid){
        super(String.format("Card with id '%s' not found", uuid));
    }
}
