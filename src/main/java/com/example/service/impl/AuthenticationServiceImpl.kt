package com.example.service.impl

import com.example.config.security.AccountUserDetailsConfiguration
import com.example.dto.mapper.RoleDtoMapper
import com.example.dto.security.AuthRequest
import com.example.dto.security.AuthResponse
import com.example.entity.Account
import com.example.entity.Role
import com.example.exception.AccountWithLoginNotFoundException
import com.example.exception.RoleWithNameNotFoundException
import com.example.repository.AccountRepository
import com.example.repository.RoleRepository
import com.example.security.jwt.JwtService
import com.example.service.AuthenticationService
import com.example.service.enums.RoleEnum
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class AuthenticationServiceImpl(
    private val accountRepository: AccountRepository,
    private val roleRepository: RoleRepository,
    private val jwtService: JwtService,
    private val authenticationManager: AuthenticationManager,
    private val passwordEncoder: PasswordEncoder,
) : AuthenticationService {
    override fun authenticate(authRequest: AuthRequest): AuthResponse {
        authenticationManager.authenticate(UsernamePasswordAuthenticationToken(authRequest.login, authRequest.password))

        val account: Account = accountRepository.findByLogin(authRequest.login)
            .orElseThrow { AccountWithLoginNotFoundException(authRequest.login) }

        val jwt: String = jwtService.generateToken(AccountUserDetailsConfiguration(account))

        return AuthResponse(
            uuid = account.id,
            token = jwt,
            roles = account.roles.stream()
                .map(RoleDtoMapper::convertEntityToDto)
                .toList()
        )
    }

    @Transactional
    override fun registrate(authRequest: AuthRequest): AuthResponse {
        val roleUser: Role = roleRepository.findByName(RoleEnum.ROLE_USER.value)
            .orElseThrow { RoleWithNameNotFoundException(RoleEnum.ROLE_USER.value) }

        val account = Account(
            authRequest.nickname,
            authRequest.login,
            authRequest.password,
            listOf(roleUser)
        )

        accountRepository.save(account)

        roleUser.accounts.plusAssign(account)

        val jwt: String = jwtService.generateToken(AccountUserDetailsConfiguration(account))

        return AuthResponse(
            uuid = account.id,
            token = jwt,
            roles = account.roles.stream()
                .map(RoleDtoMapper::convertEntityToDto)
                .toList()
        )
    }
}