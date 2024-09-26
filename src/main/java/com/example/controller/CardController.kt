package com.example.controller

import com.example.dto.card.CardCreationDto
import com.example.dto.card.CardDto
import com.example.dto.transaction.TransactionDto
import com.example.service.CardService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
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

    @PostMapping("/accounts/{accountId}")
    fun addCardToAccount(@PathVariable("accountId") accountId: UUID, @RequestBody creationDto: CardCreationDto): CardDto {
        return cardService.addCard(accountId, creationDto)
    }

    @PostMapping("/{cardId}/pay/{orderId}")
    fun payOrder(@PathVariable("cardId") cardId: UUID, @PathVariable("orderId") orderId: UUID): TransactionDto {
        return cardService.pay(cardId, orderId)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID) {
        cardService.deleteById(id)
    }
}