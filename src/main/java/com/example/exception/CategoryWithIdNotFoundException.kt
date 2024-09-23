package com.example.exception

import java.util.UUID

class CategoryWithIdNotFoundException(
    val id: UUID,
) : RuntimeException("Category with id $id not found")