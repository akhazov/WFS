package com.drmun.weather.weatherservice.service;

import com.drmun.weather.weatherservice.model.dto.CityTemp;
import com.drmun.weather.weatherservice.model.dto.WeatherDTO;
import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import com.drmun.weather.weatherservice.repository.CurrentWeatherRepository;

public class WeatherServiceImpl implements WeatherService {

    private final CurrentWeatherRepository<OpenWeatherMapResponse> repository;

    public WeatherServiceImpl(CurrentWeatherRepository<OpenWeatherMapResponse> repository) {
        this.repository = repository;
    }

    @Override
    public WeatherDTO<CityTemp> getCurrentTempByCity(String city) {
        OpenWeatherMapResponse weather = repository.getCurrentWeatherByCity(city);
        return new WeatherDTO<>(
                CityTemp.builder()
                        .temp(weather.getMain().getTemp())
                        .city(weather.getName())
                        .build()
        );
    }
}
