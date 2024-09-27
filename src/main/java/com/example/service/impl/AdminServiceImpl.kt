package com.example.service.impl

import com.example.controller.EmployerCreationDto
import com.example.dto.account.AccountFullDto
import com.example.dto.category.CategoryCreationDto
import com.example.dto.category.CategoryDto
import com.example.dto.item.ItemCreationDto
import com.example.dto.item.ItemDto
import com.example.dto.mapper.AccountDtoMapper
import com.example.dto.mapper.CategoryDtoMapper
import com.example.dto.mapper.ItemDtoMapper
import com.example.entity.Account
import com.example.entity.Category
import com.example.entity.Item
import com.example.entity.Role
import com.example.exception.AccountWithIdNotFoundException
import com.example.exception.CategoryWithIdNotFoundException
import com.example.exception.InvalidRoleDeleteException
import com.example.exception.RoleWithNameNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.CategoryRepository
import com.example.repository.ItemRepository
import com.example.repository.RoleRepository
import com.example.service.AdminService
import com.example.service.enums.RoleEnum
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class AdminServiceImpl(
    private val accountRepository: AccountRepository,
    private val itemRepository: ItemRepository,
    private val roleRepository: RoleRepository,
    private val categoryRepository:CategoryRepository,
): AdminService{
    override fun findByRoleName(roleName: String): List<AccountFullDto> {
        val role: Role = roleRepository.findByName(roleName)
            .orElseThrow { RoleWithNameNotFoundException(roleName) }

        return role.accounts.stream()
            .map(AccountDtoMapper::convertEntityToFullDto)
            .toList()
    }

    @Transactional
    override fun addEmployer(creationDto: EmployerCreationDto): AccountFullDto {
        val account = Account(
            creationDto.nickname,
            creationDto.login,
            creationDto.password
        )

        val role: Role = roleRepository.findByName(RoleEnum.ROLE_EMPLOYER.value)
            .orElseThrow { RoleWithNameNotFoundException(RoleEnum.ROLE_EMPLOYER.value) }

        account.roles = listOf(role)
        accountRepository.save(account)

        role.accounts.plusAssign(account)

        return AccountDtoMapper.convertEntityToFullDto(account)
    }

    @Transactional
    override fun addNewItem(creationDto: ItemCreationDto): ItemDto {
        val item: Item = ItemDtoMapper.convertDtoToEntity(creationDto)
        val category: Category = categoryRepository.findById(creationDto.categoryId)
            .orElseThrow { CategoryWithIdNotFoundException(creationDto.categoryId) }

        item.category = category
        itemRepository.save(item)

        category.items.plusAssign(item)

        return ItemDtoMapper.convertEntityToDto(item)
    }

    override fun addNewCategory(creationDto: CategoryCreationDto): CategoryDto {
        val category: Category = CategoryDtoMapper.convertDtoToEntity(creationDto)

        categoryRepository.save(category)

        return CategoryDtoMapper.convertEntityToDto(category)
    }

    @Transactional
    override fun addRoleToAccount(id: UUID, roleName: String): AccountFullDto {
        val account: Account = accountRepository.findById(id)
            .orElseThrow { AccountWithIdNotFoundException(id) }
        val role: Role = roleRepository.findByName(roleName)
            .orElseThrow { RoleWithNameNotFoundException(roleName) }

        account.roles.plusAssign(role)
        role.accounts.plusAssign(account)

        return AccountDtoMapper.convertEntityToFullDto(account)
    }

    override fun deleteEmployerById(id: UUID) {
        val employer = accountRepository.findById(id)
            .orElseThrow { AccountWithIdNotFoundException(id) }

        if(employer.roles.stream().noneMatch{it.name == RoleEnum.ROLE_EMPLOYER.value})
            throw InvalidRoleDeleteException(id)

        accountRepository.deleteById(id)
    }
}