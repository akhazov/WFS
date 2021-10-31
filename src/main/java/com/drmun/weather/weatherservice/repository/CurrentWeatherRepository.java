package com.drmun.weather.weatherservice.repository;

public interface CurrentWeatherRepository<T> {
    T getCurrentWeatherByCity(String city);
}
