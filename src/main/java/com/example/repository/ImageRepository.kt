package com.example.repository

import com.example.entity.Image
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.redis.core.RedisHash
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
@RedisHash
interface ImageRepository: JpaRepository<Image, UUID>