package com.example.exception

import java.util.*

class CardWithIdNotFoundException(
    id: UUID,
): RuntimeException("Card with id '$id' not found")
