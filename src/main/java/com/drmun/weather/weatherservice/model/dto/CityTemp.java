package com.drmun.weather.weatherservice.model.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CityTemp {
    private String city;
    private Double temp;
}
