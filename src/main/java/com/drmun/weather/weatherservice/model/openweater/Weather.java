package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;

@Data
public class Weather {
    private Long id;
    private String main;
    private String description;
    private String icon;
}
