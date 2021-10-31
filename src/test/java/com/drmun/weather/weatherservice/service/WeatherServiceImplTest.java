package com.drmun.weather.weatherservice.service;

import com.drmun.weather.weatherservice.model.dto.CityTemp;
import com.drmun.weather.weatherservice.model.openweater.Main;
import com.drmun.weather.weatherservice.model.openweater.OpenWeatherMapResponse;
import com.drmun.weather.weatherservice.repository.CurrentWeatherRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class WeatherServiceImplTest {

    public static final double TEMP = 10.0;
    public static final String CITY = "Москва";
    private WeatherServiceImpl sut;
    @Mock
    private CurrentWeatherRepository<OpenWeatherMapResponse> weatherRepository;

    @BeforeEach
    void setUp() {
        Mockito.doReturn(getMockResponse()).when(weatherRepository).getCurrentWeatherByCity(CITY);
        sut = new WeatherServiceImpl(weatherRepository);
    }

    @Test
    void getCurrentTempByCityTest() {
        CityTemp details = sut.getCurrentTempByCity(CITY).getDetails();
        Assertions.assertEquals(TEMP, details.getTemp());
        Assertions.assertEquals(CITY, details.getCity());
    }

    private OpenWeatherMapResponse getMockResponse() {
        Main main = Main.builder()
                .temp(TEMP)
                .build();
        return OpenWeatherMapResponse.builder()
                .main(main)
                .name(CITY)
                .build();
    }
}