package com.example.repository

import com.example.entity.Account
import org.hibernate.validator.constraints.UUID
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository: JpaRepository<Account, UUID> {
    fun findByLogin(login: String): Account?
    fun existsByLogin(login: String): Boolean
}