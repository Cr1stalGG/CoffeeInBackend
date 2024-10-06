package com.example.service;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortсutDto;
import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountFullDto> findAll();
    AccountFullDto findById(UUID uuid);
    AccountFullDto save(AccountFullDto fullDto);
    void deleteById(UUID uuid);
}
