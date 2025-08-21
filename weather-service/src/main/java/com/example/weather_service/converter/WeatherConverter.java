package com.example.weather_service.converter;


import com.example.weather_service.dto.WeatherDTO;
import com.example.weather_service.entity.WeatherEntity;
import org.springframework.stereotype.Component;

@Component
public class WeatherConverter {

    public WeatherEntity convertDTOToEntity(WeatherDTO weatherDTO) {
        WeatherEntity entity = new WeatherEntity();
        entity.setId(weatherDTO.getId());
        entity.setTempC(weatherDTO.getCurrent().getTempC());
        entity.setTempF(weatherDTO.getCurrent().getTempF());
        return entity;
    }

    public WeatherDTO convertToDTO(WeatherEntity weatherEntity) {
        WeatherDTO dto = new WeatherDTO();
        dto.setId(weatherEntity.getId());
        dto.getCurrent().setTempC(weatherEntity.getTempC());
        dto.getCurrent().setTempF(weatherEntity.getTempF());
        return dto;
    }
}
