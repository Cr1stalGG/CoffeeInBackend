package com.example.exception

class AccountWithLoginNotFoundException(
    login: String,
): RuntimeException("Account with login '$login' not found")