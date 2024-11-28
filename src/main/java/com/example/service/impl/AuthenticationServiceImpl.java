package com.example.service.impl;

import com.example.config.security.AccountUserDetailsConfiguration;
import com.example.dto.mapper.AccountDtoMapper;
import com.example.dto.mapper.RoleDtoMapper;
import com.example.dto.security.AuthRequest;
import com.example.dto.security.AuthResponse;
import com.example.entity.Account;
import com.example.entity.Role;
import com.example.exception.AccountWithLoginNotFoundException;
import com.example.exception.RoleWithNameNotFoundException;
import com.example.repository.AccountRepository;
import com.example.repository.RoleRepository;
import com.example.security.jwt.JwtService;
import com.example.service.AuthenticationService;
import com.example.service.enums.RoleEnum;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final AccountRepository accountRepository;
    private final RoleRepository roleRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;

    @Override
    public AuthResponse authenticate(AuthRequest request) {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getLogin(), request.getPassword()));

        Account account = accountRepository.findByLogin(request.getLogin())
                .orElseThrow(() -> new AccountWithLoginNotFoundException(request.getLogin()));

        String jwtToken = jwtService.generateToken(new AccountUserDetailsConfiguration(account));

        return AuthResponse.builder()
                .uuid(account.getId())
                .token(jwtToken)
                .roles(account.getRoles().stream()
                        .map(RoleDtoMapper::convertEntityToDto)
                        .toList())
                .build();
    }

    @Override
    @Transactional
    public AuthResponse registrate(AuthRequest request) {
        Role userRole = roleRepository.findByName(RoleEnum.ROLE_USER.getValue())
                .orElseThrow(() -> new RoleWithNameNotFoundException(RoleEnum.ROLE_USER.getValue()));

        Account account = Account.builder()
                .nickname(request.getNickname())
                .login(request.getLogin())
                .password(passwordEncoder.encode(request.getPassword()))
                .build();

        account.setRoles(List.of(userRole));
        accountRepository.save(account);

        userRole.getAccounts().add(account);

        String jwtToken = jwtService.generateToken(new AccountUserDetailsConfiguration(account));

        return AuthResponse.builder()
                .uuid(account.getId())
                .token(jwtToken)
                .roles(account.getRoles().stream()
                        .map(RoleDtoMapper::convertEntityToDto)
                        .toList())
                .build();
    }
}
