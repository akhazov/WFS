package com.drmun.weather.weatherservice.service;

import com.drmun.weather.weatherservice.model.dto.WeatherDTO;

public interface WeatherService {

    WeatherDTO<?> getCurrentTempByCity(String city);
}
