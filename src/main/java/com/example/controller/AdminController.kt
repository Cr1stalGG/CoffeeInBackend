package com.example.controller

import com.example.dto.account.AccountFullDto
import com.example.dto.account.EmployerCreationDto
import com.example.dto.category.CategoryCreationDto
import com.example.dto.category.CategoryDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.service.AdminService
import org.springframework.cache.annotation.CacheEvict
import org.springframework.cache.annotation.Cacheable
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/api/v1/admins")
class AdminController(
    private val adminService: AdminService,
) {
    @GetMapping("/{roleName}")
    @Cacheable(value = ["accounts"])
    fun findByRoleName(@PathVariable("roleName") roleName: String): List<AccountFullDto> {
        return adminService.findByRoleName(roleName)
    }

    @PostMapping("/employers")
    @CacheEvict(value = ["accounts"], allEntries = true)
    fun addEmployer(@RequestBody creationDto: EmployerCreationDto): AccountFullDto {
        return adminService.addEmployer(creationDto)
    }

    @PostMapping("/items")
    @CacheEvict(value = ["items"], allEntries = true)
    fun addNewItem(@RequestBody creationDto: ItemCreationDto): ItemDto {
        return adminService.addNewItem(creationDto)
    }

    @PostMapping("/categories")
    @CacheEvict(value = ["categories"], allEntries = true)
    fun addNewCategory(@RequestBody creationDto: CategoryCreationDto): CategoryDto {
        return adminService.addNewCategory(creationDto)
    }

    @PutMapping("/accounts/{accountId}/roles/{roleName}")
    @CacheEvict(value = ["accounts"], key = "#id", allEntries = true)
    fun addRoleToAccount(@PathVariable("accountId") id: UUID, @PathVariable("roleName") roleName: String): AccountFullDto {
        return adminService.addRoleToAccount(id, roleName)
    }

    @DeleteMapping("/employers/{id}")
    @CacheEvict(value = ["accounts"], key = "#id", allEntries = true)
    fun deleteEmployerById(@PathVariable("id") id: UUID) {
        return adminService.deleteEmployerById(id)
    }
}