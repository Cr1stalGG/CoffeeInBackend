package com.example.service.impl;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortcutDto;
import com.example.dto.account.AccountUpdateDto;
import com.example.dto.image.ImageCreationDto;
import com.example.dto.mapper.AccountDtoMapper;
import com.example.dto.mapper.ImageDtoMapper;
import com.example.entity.Account;
import com.example.entity.Image;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.ImageRepository;
import com.example.service.AccountService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import java.util.List;
import java.util.UUID;


@Service
@Validated
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final ImageRepository imageRepository;

    @Override
    public List<AccountShortcutDto> findAll(){
        return accountRepository.findAll().stream()
                .map(AccountDtoMapper::convertEntityToShortcutDto)
                .toList();
    }

    @Override
    public AccountFullDto findById(UUID uuid){
        Account account = accountRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));

        return AccountDtoMapper.convertEntityToFullDto(account);
    }

    @Transactional
    @Override
    public AccountFullDto setImageToAccount(UUID accountId, ImageCreationDto imageCreationDto){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountWithIdNotFoundException(accountId));

        Image image = ImageDtoMapper.convertDtoToEntity(imageCreationDto);

        imageRepository.save(image);
        account.setImage(image);
        accountRepository.save(account);

        return AccountDtoMapper.convertEntityToFullDto(account);
    }

    @Override
    public AccountFullDto updateAccount(UUID accountId, AccountUpdateDto updateDto){
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountWithIdNotFoundException(accountId));

        if(!updateDto.getLogin().isEmpty())
            account.setLogin(updateDto.getLogin());

        if(!updateDto.getNickname().isEmpty())
            account.setNickname(updateDto.getNickname());

        if(!updateDto.getPassword().isEmpty())
            account.setPassword(updateDto.getPassword());


        return AccountDtoMapper.convertEntityToFullDto(account);
    }

    @Override
    public void deleteById(UUID uuid){
        Account account = accountRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));

        accountRepository.deleteById(uuid);
    }
}
