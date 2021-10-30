package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;

@Data
public class Wind {
    private Double speed;
    private Long deg;
    private Double gust;
}
