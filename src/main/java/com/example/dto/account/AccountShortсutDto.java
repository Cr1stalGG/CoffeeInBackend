package com.example.dto.account;

import java.util.UUID;
import com.example.dto.image.ImageDto;

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
public class AccountShortсutDto {
    private UUID uuid;
    private String nickname;
    private String login;
    private ImageDto image;
}
