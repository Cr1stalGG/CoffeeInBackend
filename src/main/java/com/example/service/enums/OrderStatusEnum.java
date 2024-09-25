package com.example.service.enums;

import lombok.Getter;

public enum OrderStatusEnum {
    STATUS_TAKEN("STATUS_TAKEN"),
    STATUS_IN_PROGRESS("STATUS_IN_PROGRESS"),
    STATUS_DONE("STATUS_DONE");

    @Getter
    private final String value;

    OrderStatusEnum(String value){
        this.value = value;
    }
}
