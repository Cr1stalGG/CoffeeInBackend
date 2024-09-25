package com.example.dto.account;

import com.example.dto.image.ImageDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountShortсutDto {
    private UUID id;
    private String nickname;
    private String login;
    private ImageDto image;
}
