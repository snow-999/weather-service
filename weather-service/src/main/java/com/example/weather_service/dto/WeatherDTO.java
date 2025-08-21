package com.example.weather_service.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Setter
@Getter
public class WeatherDTO {
    private long id;
    private Current current;
    private String note;

    @Setter
    @Getter
    public static class Current {
        @JsonProperty("temp_c")
        private double tempC;
        @JsonProperty("temp_f")
        private double tempF;
        @JsonProperty("last_updated")
        private String date;
    }
}
