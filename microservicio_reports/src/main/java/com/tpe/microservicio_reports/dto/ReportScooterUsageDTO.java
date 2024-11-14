package com.tpe.microservicio_reports.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ReportScooterUsageDTO {
    @JsonProperty("id")
    private int id;

    @JsonProperty("km")
    private float km;

    @JsonProperty("timeOut")
    private float timeOut;


}