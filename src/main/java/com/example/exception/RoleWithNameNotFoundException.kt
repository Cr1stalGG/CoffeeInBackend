package com.example.exception

class RoleWithNameNotFoundException(
    roleName: String
): RuntimeException("Role with name '$roleName' not found")
