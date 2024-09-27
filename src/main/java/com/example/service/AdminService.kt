package com.example.service

import com.example.controller.EmployerCreationDto
import com.example.dto.account.AccountFullDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import java.util.*

interface AdminService {
    fun findByRoleName(roleName: String): List<AccountFullDto>
    fun addEmployer(creationDto: EmployerCreationDto): AccountFullDto
    fun addNewItem(creationDto: ItemCreationDto): ItemDto
    fun addRoleToAccount(id: UUID, roleName: String): AccountFullDto
    fun deleteEmployerById(id: UUID)
}