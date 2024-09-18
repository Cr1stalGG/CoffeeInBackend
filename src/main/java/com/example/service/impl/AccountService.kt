package com.example.service.impl

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import java.util.UUID

interface AccountService {
    fun findById(id: UUID): AccountFullDto
    fun findAll(): List<AccountShortcutDto>
    fun deleteById(id: UUID)
}