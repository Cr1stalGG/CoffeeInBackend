package com.example.service

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.account.AccountUpdateDto
import com.example.dto.image.ImageCreationDto
import java.util.UUID

interface AccountService {
    fun findById(id: UUID): AccountFullDto
    fun findAll(): List<AccountShortcutDto>
    fun updateAccount(uuid: UUID, updateDto: AccountUpdateDto): AccountFullDto
    fun setImageToAccount(uuid: UUID, imageDto: ImageCreationDto): AccountFullDto
    fun deleteById(id: UUID)
}