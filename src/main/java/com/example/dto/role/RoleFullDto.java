package com.example.dto.role;

import com.example.entity.Account;
import java.util.List;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleFullDto {
    private UUID id;
    private String name;
    private String description;
    private List<Account> accounts;
}
