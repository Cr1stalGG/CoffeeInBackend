package com.example.service.enums;

import lombok.Getter;

public enum RoleEnum {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_EMPLOYER("ROLE_EMPLOYER");

    @Getter
    private final String value;

    RoleEnum(String value){
        this.value = value;
    }

}
