package com.example.dto.account;

import com.example.dto.card.CardDto;
import com.example.dto.image.ImageDto;
import com.example.dto.role.RoleDto;
import java.util.List;
import java.util.UUID;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountFullDto {
    private UUID uuid;
    private String nickname;
    private String login;
    private ImageDto image;
    private List<CardDto> cards;
    private List<RoleDto> roles;
}
