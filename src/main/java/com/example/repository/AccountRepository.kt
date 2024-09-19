package com.example.repository

import com.example.entity.Account
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccountRepository: JpaRepository<Account, UUID> {
    fun findByLogin(login: String): Account?
    fun existsByLogin(login: String): Boolean
}