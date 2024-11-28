package com.example.dto.mapper;

import com.example.dto.account.AccountFullDto;
import com.example.dto.account.AccountShortcutDto;
import com.example.dto.card.CardDto;
import com.example.dto.role.RoleDto;
import com.example.entity.Account;
import com.example.entity.Card;
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

    public static AccountShortcutDto convertEntityToShortcutDto(Account source){
        return Optional.ofNullable(source)
                .map(AccountDtoMapper::buildShortcutDto)
                .orElse(null);
    }

    private static AccountShortcutDto buildShortcutDto(Account source){
        return AccountShortcutDto.builder()
                .uuid(source.getId())
                .nickname(source.getNickname())
                .login(source.getLogin())
                .image(ImageDtoMapper.convertEntityToDto(source.getImage()))
                .build();
    }

    private static AccountFullDto buildFullDto(Account source) {
        return AccountFullDto.builder()
                .uuid(source.getId())
                .nickname(source.getNickname())
                .login(source.getLogin())
                .cards(buildCards(source.getCards()))
                .roles(buildRoles(source.getRoles()))
                .image(ImageDtoMapper.convertEntityToDto(source.getImage()))
                .build();
    }

    private static List<CardDto> buildCards(List<Card> source) {
        if(source == null)
            return new ArrayList<>();
        else
            return source.stream()
                .map(CardDtoMapper::convertEntityToDto)
                .toList();
    }

    private static List<RoleDto> buildRoles(List<Role> source) {
        if(source == null)
            return new ArrayList<>();
        else
            return source.stream()
                    .map(RoleDtoMapper::convertEntityToDto)
                    .toList();
    }
}
