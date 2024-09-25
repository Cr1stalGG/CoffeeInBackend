package com.example.exception.handler

import com.example.exception.AccountWithIdNotFoundException
import com.example.exception.CannotChangeOrderStatusException
import com.example.exception.CategoryWithIdNotFoundException
import com.example.exception.ItemWithIdNotFoundException
import com.example.exception.OrderStatusWithNameNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandlerController {
    @ExceptionHandler(
        AccountWithIdNotFoundException::class,
        ItemWithIdNotFoundException::class,
        CategoryWithIdNotFoundException::class,
        OrderStatusWithNameNotFoundException::class,
    )
    fun handleNotFoundException(e: RuntimeException): ResponseEntity<String>{
        return ResponseEntity<String>("Not found exception: " + e.message, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler(
        CannotChangeOrderStatusException::class,
    )
    fun handleInvalidOperations(e: RuntimeException): ResponseEntity<String>{
        return ResponseEntity<String>("Invalid operation exception: " + e.message, HttpStatus.BAD_REQUEST)
    }
}