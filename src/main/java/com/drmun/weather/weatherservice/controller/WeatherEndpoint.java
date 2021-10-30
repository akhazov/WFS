package com.drmun.weather.weatherservice.controller;

import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
@RequestMapping("weather")
public class WeatherEndpoint {
    @Value("${open.weather.api.token}")
    private String apiToken;

    @GetMapping(path = "temp", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getTempByCity(String city) {
//        WeatherService.getTempByCityNow(city);
        WebClient webClient = WebClient.builder()
                .baseUrl("https://api.openweathermap.org")
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
        OpenWeatherMapResponse block = webClient.get()
                .uri(String.format("/data/2.5/weather?q=%s&appid=%s&units=%s&lang=%s", city, apiToken, "metric", "ru"))
                .retrieve()
                .bodyToMono(OpenWeatherMapResponse.class)
                .block();
        Response response = new Response();
        response.setCity(city);
        response.setTemp(block.getMain().getTemp());
        return response;
    }
}
