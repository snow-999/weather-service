package com.example.weather_service.controller;

import com.example.weather_service.dto.WeatherDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("api/v1")
public class WeatherServiceController {

    @GetMapping("hello")
    public ResponseEntity<WeatherDTO> sayHello() {

        ResponseEntity<WeatherDTO> weatherEntity = new RestTemplate().getForEntity("http://api.weatherapi.com/v1/current.json?key=005e653ed0dc4d35ac7192041200411&q=Cairo&aqi=no", WeatherDTO.class, HttpStatus.OK);
        System.out.println();
        return weatherEntity;
    }
}
