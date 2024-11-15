package com.tpe.microservicio_travels.dto;

import lombok.Data;

@Data
public class MonthBillingDTO {
    private int month;
    private float amount;

    public MonthBillingDTO(int month, float amount) {
        this.month = month;
        this.amount = amount;
    }
}
