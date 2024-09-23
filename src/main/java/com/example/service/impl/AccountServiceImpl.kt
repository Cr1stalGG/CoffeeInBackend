package com.example.service.impl

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.account.AccountUpdateDto
import com.example.dto.image.ImageCreationDto
import com.example.dto.mapper.AccountDtoMapper
import com.example.dto.mapper.ImageDtoMapper
import com.example.entity.Account
import com.example.entity.Image
import com.example.exception.AccountWithIdNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.ImageRepository
import com.example.service.AccountService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AccountServiceImpl(
    val accountRepository: AccountRepository,
    val imageRepository: ImageRepository
) : AccountService {
    override fun findById(id: UUID): AccountFullDto {
        val account: Account = accountRepository.findById(id)
            .orElseThrow{AccountWithIdNotFoundException(id)}

        return AccountDtoMapper.convertEntityToFullDto(account)
    }

    override fun findAll(): List<AccountShortcutDto> {
        return accountRepository.findAll().stream()
            .map(AccountDtoMapper::convertEntityToShortcutDto)
            .toList()
    }

    override fun updateAccount(uuid: UUID, updateDto: AccountUpdateDto): AccountFullDto {
        val account: Account = accountRepository.findById(uuid)
            .orElseThrow{AccountWithIdNotFoundException(uuid)}

        if(!updateDto.login.isNullOrEmpty())
            account.login = updateDto.login

        if(!updateDto.password.isNullOrEmpty())
            account.password = updateDto.password

        if(!updateDto.nickname.isNullOrEmpty())
            account.nickname = updateDto.nickname

        return AccountDtoMapper.convertEntityToFullDto(account)
    }

    @Transactional
    override fun setImageToAccount(uuid: UUID, imageDto: ImageCreationDto): AccountFullDto {
        val account: Account = accountRepository.findById(uuid)
            .orElseThrow{AccountWithIdNotFoundException(uuid)}
        val image: Image = ImageDtoMapper.convertDtoToEntity(imageDto)

        imageRepository.save(image)

        account.image = image

        return AccountDtoMapper.convertEntityToFullDto(account)
    }

    override fun deleteById(id: UUID) {
        val account: Account = accountRepository.findById(id)
            .orElseThrow{AccountWithIdNotFoundException(id)}

        accountRepository.deleteById(id)
    }
}