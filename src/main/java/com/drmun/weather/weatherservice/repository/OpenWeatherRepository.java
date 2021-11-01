package com.drmun.weather.weatherservice.repository;

import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import org.springframework.web.reactive.function.client.WebClient;

public class OpenWeatherRepository implements CurrentWeatherRepository<OpenWeatherMapResponse> {
    @Value("${open.weather.api.token}")
    private String apiToken;
    @Override
    public OpenWeatherMapResponse getCurrentWeatherByCity(String city) {
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.openweathermap.org")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        return webClient.get()
                .uri(String.format("/data/2.5/weather?q=%s,ru&appid=%s&units=%s&lang=%s", city, apiToken, "metric", "ru"))
                .retrieve()
                .bodyToMono(OpenWeatherMapResponse.class)
                .block();
    }
}
