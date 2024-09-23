package com.example.controller

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.account.AccountUpdateDto
import com.example.dto.image.ImageCreationDto
import com.example.service.AccountService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
@RequestMapping("/api/v1/accounts")
class AccountController (
    val accountService: AccountService
){
    @GetMapping
    fun findAll(): List<AccountShortcutDto>? {
        return accountService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): AccountFullDto {
        return accountService.findById(id)
    }

    @PutMapping("/{id}")
    fun updateAccount(@PathVariable("id") id: UUID, @RequestBody updateDto: AccountUpdateDto): AccountFullDto {
        return accountService.updateAccount(id, updateDto)
    }

    @PutMapping("/{id}/image")
    fun setImageToAccount(@PathVariable("id") id: UUID, @RequestBody imageDto: ImageCreationDto): AccountFullDto {
        return accountService.setImageToAccount(id, imageDto)
    }

    @DeleteMapping("/{id}")
    fun deleteById(@PathVariable("id") id: UUID){
        return accountService.deleteById(id)
    }
}