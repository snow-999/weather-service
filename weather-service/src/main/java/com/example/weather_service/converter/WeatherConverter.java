package com.example.weather_service.converter;


import com.example.weather_service.dto.WeatherDTO;
import com.example.weather_service.entity.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherConverter {

    public WeatherEntity convertDTOToEntity(WeatherDTO weatherDTO) {
        WeatherEntity entity = new WeatherEntity();
        entity.setId(weatherDTO.getId());
        entity.setTemp_c(weatherDTO.getCurrent().getTemp_c());
        entity.setTemp_f(weatherDTO.getCurrent().getTemp_f());
        return entity;
    }

    public WeatherDTO convertToDTO(WeatherEntity weatherEntity) {
        WeatherDTO dto = new WeatherDTO();
        dto.setId(weatherEntity.getId());
        dto.getCurrent().setTemp_c(weatherEntity.getTemp_c());
        dto.getCurrent().setTemp_f(weatherEntity.getTemp_f());
        return dto;
    }
}
