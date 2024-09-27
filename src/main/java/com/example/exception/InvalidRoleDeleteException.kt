package com.example.exception

import java.util.*

class InvalidRoleDeleteException(
    id: UUID
): RuntimeException("Account with id '$id' has no employer role")
