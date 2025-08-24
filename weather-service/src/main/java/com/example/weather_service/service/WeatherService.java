package com.example.weather_service.service;

import com.example.weather_service.converter.WeatherConverter;
import com.example.weather_service.dto.WeatherDTO;
import com.example.weather_service.entity.WeatherEntity;
import com.example.weather_service.exception.CItyNotFound;
import com.example.weather_service.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public WeatherDTO saveCurrentWeather (String cityName) {
        ResponseEntity<WeatherDTO> weatherDTO = new RestTemplate().getForEntity("http://api.weatherapi.com/v1/current.json?key=005e653ed0dc4d35ac7192041200411&q="+cityName+"&aqi=no", WeatherDTO.class, HttpStatus.OK);
        System.out.println(weatherDTO.getBody().getCurrent().getTempC());
        if (weatherDTO.getBody() == null) {
            throw new CItyNotFound("no city with this name");
        }
        WeatherEntity weatherEntity = weatherConverter.convertDTOToEntity(weatherDTO.getBody());
        weatherEntity = weatherRepository.save(weatherEntity);
        return  weatherConverter.convertToDTO(weatherEntity);
    }
}
