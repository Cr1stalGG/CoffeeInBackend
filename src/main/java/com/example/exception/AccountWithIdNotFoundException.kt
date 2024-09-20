package com.example.exception

import java.util.UUID

class AccountWithIdNotFoundException(
    id: UUID,
): RuntimeException(String.format("Account with id %s not found", id))