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
        if (weatherDTO.getBody() == null) {
            throw new CItyNotFound("no city with this name");
        }
        WeatherEntity weatherEntity = weatherConverter.convertDTOToEntity(weatherDTO.getBody());
        weatherEntity.setNote(setNotes(weatherEntity.getTempC()));
        System.out.println(weatherEntity);
        weatherEntity = weatherRepository.save(weatherEntity);
        return  weatherConverter.convertToDTO(weatherEntity);
    }

    public String setNotes(double temp) {

        String COLD_WEATHER_NOTE = "weather is cold today pls wear heavy clothes";
        String GOOD_WEATHER_NOTE = "weather today is good have a nice day";
        String HOT_WEATHER_NOTE = "weather is extremely hot pls don't go out";
        String SUNNY_WEATHER_NOTE = "weather is sunny today be carful";



        boolean coldWeather = (int) temp <= 20 && (int) temp >= 1;
        boolean goodWeather = (int) temp <= 30  && (int) temp > 20;
        boolean sunnyWeather = (int) temp <= 40 && (int) temp > 30;


        if (coldWeather) {
            return COLD_WEATHER_NOTE;
        } else if (goodWeather) {
            return GOOD_WEATHER_NOTE;
        } else if (sunnyWeather) {
            return SUNNY_WEATHER_NOTE;
        } else {
            return HOT_WEATHER_NOTE;
        }
    }
}
