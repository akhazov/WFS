package com.drmun.weather.weatherservice.model.openweater;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Main {
    private Double temp;
    private Double feels_like;
    private Double temp_min;
    private Double temp_max;
    private Long pressure;
    private Long humidity;
}
