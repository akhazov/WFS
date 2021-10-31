package com.drmun.weather.weatherservice;

import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import com.drmun.weather.weatherservice.repository.CurrentWeatherRepository;
import com.drmun.weather.weatherservice.repository.OpenWeatherRepository;
import com.drmun.weather.weatherservice.service.WeatherService;
import com.drmun.weather.weatherservice.service.WeatherServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;

@SpringBootApplication
public class WeatherServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(WeatherServiceApplication.class, args);
    }

    @Bean
    public CurrentWeatherRepository<OpenWeatherMapResponse> currentWeatherRepository() {
        return new OpenWeatherRepository();
    }

    @Bean
    public WeatherService weatherService() {
        return new WeatherServiceImpl(currentWeatherRepository());
    }

}
