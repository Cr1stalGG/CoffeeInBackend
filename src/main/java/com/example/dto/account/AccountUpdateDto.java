package com.example.dto.account;

import com.example.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountUpdateDto {
    private String nickname;
    private String password;
    private Image image;
}
