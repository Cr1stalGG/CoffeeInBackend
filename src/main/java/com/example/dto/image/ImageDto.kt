package com.example.dto.image

import java.util.UUID

data class ImageDto(
    val uuid: UUID,
    val objectName: String,
    val bucketName: String,
)
