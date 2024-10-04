package com.example.controller

import com.example.dto.account.AccountFullDto
import com.example.dto.account.AccountShortcutDto
import com.example.dto.account.AccountUpdateDto
import com.example.dto.image.ImageCreationDto
import com.example.service.AccountService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/accounts")
class AccountController (
    private val accountService: AccountService
){
    @GetMapping
    @Cacheable(value = ["accounts"])
    fun findAll(): List<AccountShortcutDto>? {
        return accountService.findAll()
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable("id") id: UUID): AccountFullDto {
        return accountService.findById(id)
    }

    @PutMapping("/{id}")
    @CacheEvict(key = "#id", value = ["accounts"], allEntries = true)
    fun updateAccount(@PathVariable("id") id: UUID, @RequestBody updateDto: AccountUpdateDto): AccountFullDto {
        return accountService.updateAccount(id, updateDto)
    }

    @PutMapping("/{id}/image")
    @CacheEvict(value = ["accounts"], key = "#id", allEntries = true)
    fun setImageToAccount(@PathVariable("id") id: UUID, @RequestBody imageDto: ImageCreationDto): AccountFullDto {
        return accountService.setImageToAccount(id, imageDto)
    }

    @DeleteMapping("/{id}")
    @CacheEvict(value = ["accounts"], key = "#id", allEntries = true)
    fun deleteById(@PathVariable("id") id: UUID){
        return accountService.deleteById(id)
    }
}