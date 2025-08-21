package com.example.weather_service.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherDTO {
    private long id;
    private Current current;

    @Setter
    @Getter
    public static class Current {
        private double temp_c;
        private double temp_f;

    }
}
