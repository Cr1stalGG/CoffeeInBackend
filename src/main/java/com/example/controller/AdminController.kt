package com.example.controller

import com.example.dto.account.AccountFullDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.service.AdminService
import org.springframework.web.bind.annotation.DeleteMapping
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
    fun findByRoleName(@PathVariable("roleName") roleName: String): List<AccountFullDto> {
        return adminService.findByRoleName(roleName)
    }

    @PostMapping("/employers")
    fun addEmployer(@RequestBody creationDto: EmployerCreationDto): AccountFullDto {
        return adminService.addEmployer(creationDto)
    }

    @PostMapping("/items")
    fun addNewItem(@RequestBody creationDto: ItemCreationDto): ItemDto {
        return adminService.addNewItem(creationDto)
    }

    @PutMapping("/accounts/{accountId}/roles/{roleName}")
    fun addRoleToAccount(@PathVariable("accountId") id: UUID, @PathVariable("roleName") roleName: String): AccountFullDto {
        return adminService.addRoleToAccount(id, roleName)
    }

    @DeleteMapping("/employers/{id}")
    fun deleteEmployerById(@PathVariable("id") id: UUID) {
        return adminService.deleteEmployerById(id)
    }
}