package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;

@Data
public class Main {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Long pressure;
    private Long humidity;
}
