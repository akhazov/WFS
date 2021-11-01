package com.drmun.weather.weatherservice.controller;

import com.drmun.weather.weatherservice.controller.dto.Response;
import com.drmun.weather.weatherservice.model.dto.CityTemp;
import com.drmun.weather.weatherservice.model.openweater.Main;
import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import com.drmun.weather.weatherservice.repository.CurrentWeatherRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(MockitoExtension.class)
class WeatherEndpointTest {

    public static final String CITY = "Пенза";
    @LocalServerPort
    private Integer port;
    @Autowired
    private WebTestClient webClient;

    @Test
    @DisplayName("Тест контроллера температуры по городу.")
    void getTempByCity() {
        webClient.get()
                .uri("/weather/temp?city=" + CITY)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.content.details.city").isEqualTo(CITY)
                .jsonPath("$.content.details.temp").isNotEmpty();
    }

}