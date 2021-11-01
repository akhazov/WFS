package com.drmun.weather.weatherservice.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WeatherDTO<T> {
    private T details;
}
