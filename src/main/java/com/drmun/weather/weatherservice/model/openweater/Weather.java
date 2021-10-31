package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
