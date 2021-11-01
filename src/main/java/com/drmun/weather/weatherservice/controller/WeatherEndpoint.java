package com.drmun.weather.weatherservice.controller;

import com.drmun.weather.weatherservice.service.WeatherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("weather")
public class WeatherEndpoint {

    private final WeatherService service;

    public WeatherEndpoint(WeatherService service) {
        this.service = service;
    }

    @GetMapping(path = "temp", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getTempByCity(String city) {
        return ResponseEntity.ok(service.getCurrentTempByCity(city));
    }
}
