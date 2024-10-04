package com.example.service

import com.example.dto.account.EmployerCreationDto
import com.example.dto.account.AccountFullDto
import com.example.dto.category.CategoryCreationDto
import com.example.dto.category.CategoryDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import java.util.*

interface AdminService {
    fun findByRoleName(roleName: String): List<AccountFullDto>
    fun addEmployer(creationDto: EmployerCreationDto): AccountFullDto
    fun addNewItem(creationDto: ItemCreationDto): ItemDto
    fun addNewCategory(creationDto: CategoryCreationDto): CategoryDto
    fun addRoleToAccount(id: UUID, roleName: String): AccountFullDto
    fun deleteEmployerById(id: UUID)
}