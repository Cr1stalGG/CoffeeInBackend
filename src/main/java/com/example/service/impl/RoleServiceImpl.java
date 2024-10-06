package com.example.service.impl;

import com.example.dto.mapper.RoleDtoMapper;
import com.example.dto.role.RoleDto;
import com.example.entity.Role;
import com.example.exception.AccountWithIdNotFoundException;
import com.example.repository.RoleRepository;
import com.example.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{

    private final RoleRepository roleRepository;

    @Override
    public List<RoleDto> findAll(){
        return roleRepository.findAll().stream()
                .map(RoleDtoMapper::convertEntityToDto)
                .toList();
    }

    @Override
    public RoleDto findById(UUID uuid){
        Role role = roleRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        return RoleDtoMapper.convertEntityToDto(role);
    }

    @Override
    public RoleDto save(RoleDto roleDto){
        Role role = RoleDtoMapper.convertDtoToEntity(roleDto);
        roleRepository.save(role);
        return RoleDtoMapper.convertEntityToDto(role);
    }

    @Override
    public void deleteById(UUID uuid){
        Role role = roleRepository.findById(uuid)
                .orElseThrow(() -> new AccountWithIdNotFoundException(uuid));
        roleRepository.deleteById(uuid);
    }
}
