package com.drmun.weather.weatherservice.model.openweater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OpenWeatherMapResponse {
    private Coordinate coord;
    private List<Weather> weather;
    private String base;
    private Main main;
    private Long visibility;
    private Wind wind;
    private Clouds clouds;
    private Long dt;
    private SystemInfo sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;
}
