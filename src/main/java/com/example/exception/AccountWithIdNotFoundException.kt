package com.example.exception

import java.util.UUID

class AccountWithIdNotFoundException(
    id: UUID,
): Exception(String.format("Account with id %s not found", id))