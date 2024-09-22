package com.example.dto.account;

import com.example.dto.image.ImageDto;
import lombok.*;
import java.util.UUID;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccountShortCutDto {
    private UUID id;
    private String nickname;
    private String login;
    private ImageDto image;
}
