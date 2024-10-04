package com.example.repository

import com.example.entity.Item
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.redis.core.RedisHash
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
@RedisHash
interface ItemRepository: JpaRepository<Item, UUID>