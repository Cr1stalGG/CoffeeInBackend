package com.example.dto.account;

import com.example.dto.card.CardDto;
import com.example.dto.image.ImageDto;
import com.example.dto.role.RoleDto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountFullDto {
    private UUID id;
    private String nickname;
    private String login;
    private ImageDto image;
    private List<CardDto> cards;
    private List<RoleDto> roles;
}
