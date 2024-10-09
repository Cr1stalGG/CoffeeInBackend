package com.example.service.impl;

import com.example.dto.mapper.RoleDtoMapper;
import com.example.dto.role.RoleDto;
import com.example.entity.Role;
import com.example.exception.RoleWithIdNotFoundException;
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
                .orElseThrow(() -> new RoleWithIdNotFoundException(uuid));
        return RoleDtoMapper.convertEntityToDto(role);
    }

    @Override
    public void deleteById(UUID uuid){
        Role role = roleRepository.findById(uuid)
                .orElseThrow(() -> new RoleWithIdNotFoundException(uuid));
        roleRepository.deleteById(uuid);
    }
}
