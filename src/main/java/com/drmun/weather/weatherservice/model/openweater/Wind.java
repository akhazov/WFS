package com.drmun.weather.weatherservice.model.openweater;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Wind {
    private Double speed;
    private Long deg;
    private Double gust;
}
