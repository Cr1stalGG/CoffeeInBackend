package com.example.controllers;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortcutDto;
import com.example.dto.account.AccountUpdateDto;
import com.example.dto.image.ImageCreationDto;
import com.example.service.AccountService;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping
    @Cacheable(value = "accounts")
    public List<AccountShortcutDto> findAll() {
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public AccountFullDto findById(@PathVariable("id") UUID id) {
        return accountService.findById(id);
    }

    @PutMapping("/{id}")
    @CacheEvict(value = "accounts", key = "#id", allEntries = true)
    public AccountFullDto updateAccount(@PathVariable("id") UUID id, @RequestBody AccountUpdateDto updateDto) {
        return accountService.updateAccount(id, updateDto);
    }

    @PutMapping("/{id}/image")
    @CacheEvict(value = "accounts", key = "#id", allEntries = true)
    public AccountFullDto setImageToAccount(@PathVariable("id") UUID id, @RequestBody ImageCreationDto imageDto) {
        return accountService.setImageToAccount(id, imageDto);
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = "accounts", key = "#id", allEntries = true)
    public ResponseEntity<Void> deleteById(@PathVariable("id") UUID id) {
        accountService.deleteById(id);
        return ResponseEntity.noContent().build(); // Возвращаем статус 204 No Content
    }
}
