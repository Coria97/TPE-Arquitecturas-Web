package com.tpe.microservicio_travels.dto;

import lombok.Data;

import java.util.List;

@Data
public class BillingResponseDTO {
    private double total;
    private List<MonthBillingDTO> monthBills;

    // Constructor
    public BillingResponseDTO(double total, List<MonthBillingDTO> monthBills) {
        this.total = total;
        this.monthBills = monthBills;
    }
}
