package com.example.exception;

import java.util.UUID;

public class ImageWithIdNotFoundException extends RuntimeException{
    public ImageWithIdNotFoundException(UUID uuid){
        super(String.format("Image with id %s not found", uuid));
    }
}
