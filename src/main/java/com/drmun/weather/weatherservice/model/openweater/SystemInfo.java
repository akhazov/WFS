package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;

@Data
public class SystemInfo {
    private Long type;
    private Long id;
    private String country;
    private Long sunrise;
    private Long sunset;
}
