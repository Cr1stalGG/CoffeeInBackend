package com.example.controller

import com.example.dto.card.CardDto
import com.example.service.CardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/cards")
class CardController(
    private val cardService: CardService,
) {
    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): CardDto {
        return cardService.findById(id)
    }

    @GetMapping("/accounts/{accountId}")
    fun findByAccountId(@PathVariable("accountId") accountId: UUID): List<CardDto> {
        return cardService.findByAccountId(accountId)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID) {
        cardService.deleteById(id)
    }
}