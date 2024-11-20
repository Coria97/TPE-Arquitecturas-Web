package com.tpe.microservicio_travels.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data

public class ScooterStatsUpdateDTO {
    @JsonProperty("km")
    private float km;
    @JsonProperty("timeUsage")
    private float timeUsage;
    @JsonProperty("stopId")
    private long stopId;

    public ScooterStatsUpdateDTO() {}

    public ScooterStatsUpdateDTO(float km, float timeUsage, long stopId) {
        this.km = km;
        this.timeUsage = timeUsage;
        this.stopId = stopId;
    }
}
