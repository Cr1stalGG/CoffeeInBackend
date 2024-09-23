package com.example.exception

import java.util.UUID

class ItemWithIdNotFoundException(
    val id: UUID,
) : RuntimeException("Item with id $id not found Exception")
