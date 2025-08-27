package com.example.weather_service.controller;

import com.example.weather_service.dto.WeatherDTO;
import com.example.weather_service.entity.WeatherEntity;
import com.example.weather_service.service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1")
public class WeatherServiceController {

    @Autowired
    private WeatherService weatherService;


    @GetMapping("hello")
    public String sayHello() {
        return "hihi";
    }

    @PostMapping("setweather/{cityName}")
    public ResponseEntity<WeatherDTO> saveCurrentWeather(@PathVariable String cityName) {
        WeatherDTO weatherDTO = weatherService.saveCurrentWeather(cityName);
        return new ResponseEntity<>(weatherDTO, HttpStatus.CREATED);
    }

    @GetMapping("getweather")
    public ResponseEntity<List<WeatherDTO>> getAllCurrentWeather() {
        List<WeatherDTO> dtoList = weatherService.getCurrentWeather();
        return new ResponseEntity<>(dtoList, HttpStatus.OK);
    }

    @GetMapping("getnotes")
    public List<String> getAllNotes() {
        return weatherService.getAllNotes();
    }

}
