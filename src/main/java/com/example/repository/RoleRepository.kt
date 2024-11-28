package com.example.repository

import com.example.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.redis.core.RedisHash
import org.springframework.stereotype.Repository
import java.util.*
import javax.swing.text.html.Option

@Repository
@RedisHash
interface RoleRepository: JpaRepository<Role, UUID> {
    fun findByName(name: String): Optional<Role>
}