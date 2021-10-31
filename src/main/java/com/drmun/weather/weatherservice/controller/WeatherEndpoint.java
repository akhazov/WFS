package com.drmun.weather.weatherservice.controller;

import com.drmun.weather.weatherservice.controller.dto.Response;
import com.drmun.weather.weatherservice.model.dto.WeatherDTO;
import com.drmun.weather.weatherservice.service.WeatherService;
import org.springframework.http.MediaType;
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
    public Response getTempByCity(String city) {
        return Response.builder()
                .content(service.getCurrentTempByCity(city))
                .build();
    }
}
