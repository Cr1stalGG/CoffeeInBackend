package com.example.controllers;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.transaction.TransactionDto;
import com.example.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/cards")
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping("/{id}")
    public ResponseEntity<CardDto> findById(@PathVariable("id") UUID id) {
        CardDto card = cardService.findById(id);
        return ResponseEntity.ok(card);
    }

    @GetMapping("/accounts/{accountId}")
    public ResponseEntity<List<CardDto>> findByAccountId(@PathVariable("accountId") UUID accountId) {
        List<CardDto> cards = cardService.findByAccountId(accountId);
        return ResponseEntity.ok(cards);
    }

    @PostMapping("/accounts/{accountId}")
    public ResponseEntity<CardDto> addCardToAccount(
            @PathVariable("accountId") UUID accountId,
            @RequestBody CardCreationDto creationDto) {
        CardDto card = cardService.save(accountId, creationDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(card);
    }

    @PostMapping("/{cardId}/pay/{orderId}")
    public ResponseEntity<TransactionDto> payOrder(
            @PathVariable("cardId") UUID cardId,
            @PathVariable("orderId") UUID orderId,
            @RequestBody TransactionDto creationDto) {
        TransactionDto transaction = cardService.pay(cardId, orderId, creationDto);
        return ResponseEntity.ok(transaction);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        cardService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
