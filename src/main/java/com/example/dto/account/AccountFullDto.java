package com.example.dto.account;

import com.example.dto.card.CardDto;
import com.example.dto.role.RoleDto;
import com.example.entity.Image;
import lombok.*;
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
    private Image image;
    private List<CardDto> cards;
    private List<RoleDto> roles;
}
