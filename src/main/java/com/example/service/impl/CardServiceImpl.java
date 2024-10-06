package com.example.service.impl;

import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.mapper.CardDtoMapper;
import com.example.entity.Account;
import com.example.entity.Card;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.CardRepository;
import com.example.service.CardService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@EnableTransactionManagement
public class CardServiceImpl implements CardService{

    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;

    @Override
    public List<CardDto> findAll(){
        return cardRepository.findAll().stream()
                .map(CardDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public CardDto findById(UUID uuid){
        Card card = cardRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return CardDtoMapper.convertEntityToDto(card);
    }

    @Transactional
    @Override
    public CardDto save(UUID accountId, CardCreationDto cardCreationDto) {
        Optional<Account> account = accountRepository.findById(accountId);
        if (account.isPresent()) {
            Card card = CardDtoMapper.convertDtoToEntity(cardCreationDto);
            card.setOwner(account.get());
            cardRepository.save(card);
            account.get().getCards().add(card);
            accountRepository.save(account.get());
            return CardDtoMapper.convertEntityToDto(card);
        } else {
            throw new AccountWithIdNotFoundException(accountId);
        }
    }

    @Override
    public void deleteById(UUID uuid) {
        Card card = cardRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        cardRepository.deleteById(uuid);
    }
}
