package com.example.service.impl;

import com.example.dto.account.AccountFullDto;
import com.example.dto.mapper.AccountDtoMapper;
import com.example.entity.Account;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.AccountRepository;
import com.example.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;

    @Override
    public List<AccountFullDto> findAll(){
        return accountRepository.findAll().stream()
                .map(AccountDtoMapper::convertEntityToFullDto)
                .toList();
    }

    @Override
    public AccountFullDto findById(UUID uuid){
        Account account = accountRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return AccountDtoMapper.convertEntityToFullDto(account);
    }

    @Override
    public AccountFullDto save(AccountFullDto fullDto){
        Account account = AccountDtoMapper.convertDtoToEntity(fullDto);
        accountRepository.save(account);
        return AccountDtoMapper.convertEntityToFullDto(account);
    }

    @Override
    public void deleteById(UUID uuid){
        Account account = accountRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        accountRepository.deleteById(uuid);
    }
}
