package com.example.weather_service.service;

import com.example.weather_service.converter.WeatherConverter;
import com.example.weather_service.dto.WeatherDTO;
import com.example.weather_service.entity.WeatherEntity;
import com.example.weather_service.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private  WeatherRepository weatherRepository;
    @Autowired
    private WeatherConverter weatherConverter;

    public List<WeatherDTO> getCurrentWeather() {
        List<WeatherEntity> weatherEntityList = weatherRepository.findAll();
        return weatherEntityList.stream().map(weatherConverter::convertToDTO).toList();
    }

    public WeatherDTO saveCurrentWeather (WeatherDTO weatherDTO) {
        WeatherEntity weatherEntity = weatherConverter.convertDTOToEntity(weatherDTO);
        weatherEntity = weatherRepository.save(weatherEntity);
        return  weatherConverter.convertToDTO(weatherEntity);;
    }
}
