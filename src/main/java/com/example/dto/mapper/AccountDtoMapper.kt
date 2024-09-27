package com.example.dto.mapper

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.card.CardDto
import com.example.dto.image.ImageDto
import com.example.dto.role.RoleDto
import com.example.entity.Account
import com.example.entity.Card
import com.example.entity.Image
import com.example.entity.Role
import lombok.experimental.UtilityClass

object AccountDtoMapper {
    fun convertEntityToFullDto(source: Account): AccountFullDto{
        return AccountFullDto(
            uuid = source.id,
            login = source.login,
            nickname = source.nickname,
            image = buildImage(source.image),
            cards = buildCards(source.cards),
            roles = buildRoles(source.roles)
        )
    }

    fun convertEntityToShortcutDto(source: Account): AccountShortcutDto {
        return AccountShortcutDto(
            uuid = source.id,
            login = source.login,
            nickname = source.nickname,
            image = buildImage(source.image)
        )
    }

    private fun buildImage(source: Image?): ImageDto? {
        if(source != null)
            return ImageDtoMapper.convertEntityToDto(source)

        return null
    }

    private fun buildRoles(source: List<Role>?): List<RoleDto> {
        return source?.stream()!!
            .map(RoleDtoMapper::convertEntityToDto)
            .toList() ?: ArrayList()
    }

    private fun buildCards(source: List<Card>?): List<CardDto> {
        return source?.stream()!!
            .map(CardDtoMapper::convertEntityToDto)
            .toList() ?: ArrayList()
    }
}