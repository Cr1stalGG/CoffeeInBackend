package com.example.dto.card;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
public class CardCreationDto {

    @Size(min = 16, max = 16, message = "Card number must be 16 digits long")
    @Pattern(regexp = "^[0-9]$", message = "Card number must contain only digits")
    @NotBlank(message = "Card number cannot be blank")
    private String number;

    @Size(min = 4, max= 4, message = "Card's password must be exactly 4 characters long")
    @NotBlank(message = "Card's password number cannot be blank")
    private String password;

    @Size(min = 3, max= 3, message = "CVV must be exactly 3 characters long")
    @NotBlank(message="CVV cannot be blank")
    private String cvv;
}
