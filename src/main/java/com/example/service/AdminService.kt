package com.example.service

import com.example.dto.account.AccountFullDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import java.util.*

interface AdminService {
    fun findById(id: UUID): AccountFullDto //TODO("mb replace with AdminDto")
    fun findByRole_Name(roleName: String): AccountFullDto
    //fun addEmployer(creationDto: EmployerCreationDto): AccountFullDto
    fun addNewItem(creationDto: ItemCreationDto): ItemDto
    fun addRoleToAccount(id: UUID, roleName: String): AccountFullDto
    fun deleteById(id: UUID)
}