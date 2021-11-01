package com.drmun.weather.weatherservice.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.web.reactive.server.WebTestClient;

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