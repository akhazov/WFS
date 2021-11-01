package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SystemInfo {
    private Long type;
    private Long id;
    private String country;
    private Long sunrise;
    private Long sunset;
}
