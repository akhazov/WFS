package com.drmun.weather.weatherservice.controller;

import lombok.Data;

@Data
public class Response {
    private String city;
    private Double temp;
}
