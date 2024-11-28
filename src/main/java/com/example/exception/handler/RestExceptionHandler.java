package com.example.exception.handler;

import com.example.exception.AccountWithIdNotFoundException;
import com.example.exception.CardWithIdNotFoundException;
import com.example.exception.CategoryWithIdNotFoundException;
import com.example.exception.ImageWithIdNotFoundException;
import com.example.exception.ItemWithIdNotFoundException;
import com.example.exception.LackOfMoneyException;
import com.example.exception.OrderStatusWithIdNotFoundException;
import com.example.exception.OrderStatusWithNameNotFoundException;
import com.example.exception.OrderWithIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RestExceptionHandler {
    @ExceptionHandler(value = {
            AccountWithIdNotFoundException.class,
            CardWithIdNotFoundException.class,
            CategoryWithIdNotFoundException.class,
            ImageWithIdNotFoundException.class,
            ItemWithIdNotFoundException.class,
            OrderStatusWithIdNotFoundException.class,
            OrderStatusWithNameNotFoundException.class,
            OrderWithIdNotFoundException.class

    })
    public ResponseEntity<String> handleNotFoundException(Exception e){
        return new ResponseEntity<>("Not found error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {
            LackOfMoneyException.class
    })
    public ResponseEntity<String> handleInvalidOperationException(Exception e) {
        return new ResponseEntity<>("Cannot do operation error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
