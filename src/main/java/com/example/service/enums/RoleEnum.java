package com.example.service.enums;

public enum RoleEnum {
    ROLE_USER("ROLE_USER"),
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_EMPLOYER("ROLE_EMPLOYER");

    private String value;

    RoleEnum(String value){
        this.value = value;
    }

    public String getValue(){
        return this.value;
    }
}
