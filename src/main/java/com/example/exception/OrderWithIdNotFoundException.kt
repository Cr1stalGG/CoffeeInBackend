package com.example.exception

import java.util.*

class OrderWithIdNotFoundException(
    id: UUID,
): RuntimeException("Order with id $id not found")
