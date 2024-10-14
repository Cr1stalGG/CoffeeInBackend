package com.example.service.impl;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.mapper.CardDtoMapper;
import com.example.dto.mapper.TransactionDtoMapper;
import com.example.dto.transaction.TransactionDto;
import com.example.entity.Account;
import com.example.entity.Card;
import com.example.entity.Order;
import com.example.entity.Transaction;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.exception.CardWithIdNotFoundException;
import com.example.exception.LackOfMoneyException;
import com.example.exception.OrderWithIdNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.CardRepository;
import com.example.repository.OrderRepository;
import com.example.repository.TransactionRepository;
import com.example.service.CardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final OrderRepository orderRepository;
    private final TransactionRepository transactionRepository;

    @Override
    public List<CardDto> findByAccountId(UUID uuid){
        return cardRepository.findByOwner_Id(uuid).stream()
                .map(CardDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public CardDto findById(UUID uuid){
        Card card = cardRepository.findById(uuid)
                .orElseThrow(() -> new CardWithIdNotFoundException(uuid));

        return CardDtoMapper.convertEntityToDto(card);
    }

    @Transactional
    @Override
    public CardDto save(UUID accountId, CardCreationDto cardCreationDto) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountWithIdNotFoundException(accountId));

        Card card = CardDtoMapper.convertDtoToEntity(cardCreationDto);

        card.setOwner(account);
        cardRepository.save(card);

        account.getCards().add(card);

        return CardDtoMapper.convertEntityToDto(card);
    }

    @Override
    @Transactional
    public TransactionDto pay(UUID cardId, UUID orderId, TransactionDto creationDto){
        Card card = cardRepository.findById(cardId)
                .orElseThrow(() -> new CardWithIdNotFoundException(cardId));

        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new OrderWithIdNotFoundException(orderId));

        if (card.getMoney() < order.getSummaryPrice())
            throw new LackOfMoneyException(card.getNumber(), order.getSummaryPrice());


        card.setMoney(card.getMoney() - order.getSummaryPrice());

        Transaction transaction = Transaction.builder()
                .timeOfTransaction(new Date(System.currentTimeMillis()))
                .card(card)
                .order(order)
                .build();

        transactionRepository.save(transaction);

        card.getTransactions().add(transaction);
        cardRepository.save(card);

        return TransactionDtoMapper.convertEntityToDto(transaction);
    }

    @Override
    public void deleteById(UUID uuid) {
        Card card = cardRepository.findById(uuid)
                .orElseThrow(() -> new CardWithIdNotFoundException(uuid));

        cardRepository.deleteById(uuid);
    }
}
