package com.example.dto.account;

import com.example.entity.Card;
import com.example.entity.Image;
import com.example.entity.Order;
import com.example.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountFullDto {
    private UUID id;
    private String nickname;
    private String login;
    private String password;
    private Image image;
    private List<Card> cards;
    private List<Order> orders;
    private List<Role> roles;
}
