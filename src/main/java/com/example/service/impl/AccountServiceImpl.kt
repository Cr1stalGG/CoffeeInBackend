package com.example.service.impl

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.mapper.AccountDtoMapper
import com.example.entity.Account
import com.example.exception.AccountWithIdNotFoundException
import com.example.repository.AccountRepository
import com.example.service.AccountService
import org.springframework.stereotype.Service
import java.util.*

@Service
class AccountServiceImpl(
    val accountRepository: AccountRepository
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

    override fun deleteById(id: UUID) {
        val account: Account = accountRepository.findById(id)
            .orElseThrow{AccountWithIdNotFoundException(id)}

        accountRepository.deleteById(id)
    }
}