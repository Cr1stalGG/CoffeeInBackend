package com.example.service;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortcutDto;
import com.example.dto.account.AccountUpdateDto;
import com.example.dto.image.ImageCreationDto;

import java.util.List;
import java.util.UUID;

public interface AccountService {
    List<AccountShortcutDto> findAll();
    AccountFullDto findById(UUID uuid);
    AccountFullDto setImageToAccount(UUID accountId, ImageCreationDto imageDto);
    AccountFullDto updateAccount(UUID accountId, AccountUpdateDto updateDto);
    void deleteById(UUID uuid);
}
