package com.example.dto.account;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
public class AccountUpdateDto {
    @NotBlank(message="Account nickname is required")
    private String nickname;

    @NotBlank(message ="Account login is required")
    private String login;

    @Size(min = 8, message = "Account password must be at least 8 characters long")
    private String password;
}
