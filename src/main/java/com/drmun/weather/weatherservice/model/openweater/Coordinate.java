package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Coordinate {
    private Double lon;
    private Double lat;
}
