package com.example.dto.mapper;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortсutDto;
import com.example.dto.card.CardCreationDto;
import com.example.dto.card.CardDto;
import com.example.dto.role.RoleDto;
import com.example.entity.Account;
import com.example.entity.Card;
import com.example.entity.Image;
import com.example.entity.Role;
import lombok.experimental.UtilityClass;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@UtilityClass
public class AccountDtoMapper {
    public static AccountFullDto convertEntityToFullDto(Account source){
        return Optional.ofNullable(source)
                .map(AccountDtoMapper::buildFullDto)
                .orElse(null);
    }

    public static AccountShortсutDto convertEntityToShortcutDto(Account source){
        return Optional.ofNullable(source)
                .map(AccountDtoMapper::buildShortcutDto)
                .orElse(null);
    }

    private static AccountShortсutDto buildShortcutDto(Account source){
        return AccountShortсutDto.builder()
                .nickname(source.getNickname())
                .login(source.getLogin())
                .image(ImageDtoMapper.convertEntityToDto(source.getImage()))
                .build();
    }

    private static AccountFullDto buildFullDto(Account source) {
        return AccountFullDto.builder()
                .nickname(source.getNickname())
                .login(source.getLogin())
                .image(ImageDtoMapper.convertEntityToDto(source.getImage()))
                .build();
    }


}
