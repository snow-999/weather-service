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
        entity.setDate(weatherDTO.getCurrent().getDate());
        entity.setWindMPH(weatherDTO.getCurrent().getWindMPH());
        entity.setNote(weatherDTO.getNote());
        entity.setIcon(weatherDTO.getCurrent().getCondition().getIcon());
        entity.setCityName(weatherDTO.getLocation().getCityName());
        return entity;
    }

    public WeatherDTO convertToDTO(WeatherEntity weatherEntity) {
        WeatherDTO dto = new WeatherDTO();
        dto.setId(weatherEntity.getId());
        dto.setCurrent(new WeatherDTO.Current());
        dto.setLocation(new WeatherDTO.Location());
        dto.getCurrent().setCondition(new WeatherDTO.Condition());
        dto.getCurrent().setTempC(weatherEntity.getTempC());
        dto.getCurrent().setTempF(weatherEntity.getTempF());
        dto.getCurrent().setDate(weatherEntity.getDate());
        dto.getCurrent().setWindMPH(weatherEntity.getWindMPH());
        dto.getCurrent().getCondition().setIcon(weatherEntity.getIcon());
        dto.setNote(weatherEntity.getNote());
        dto.getLocation().setCityName(weatherEntity.getCityName());
        return dto;
    }
}
