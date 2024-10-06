package com.example.service.impl;

import com.example.dto.mapper.TransactionDtoMapper;
import com.example.dto.transaction.TransactionDto;
import com.example.entity.Transaction;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.CardRepository;
import com.example.repository.OrderRepository;
import com.example.repository.TransactionRepository;
import com.example.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final CardRepository cardRepository;
    private final OrderRepository orderRepository;

    @Override
    public List<TransactionDto> findAll(){
        return transactionRepository.findAll().stream()
                .map(TransactionDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public TransactionDto findById(UUID uuid){
        Transaction transaction = transactionRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return TransactionDtoMapper.convertEntityToDto(transaction);
    }

    @Override
    public void deleteById(UUID uuid){
        Transaction transaction = transactionRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
       transactionRepository.deleteById(uuid);
    }
}
