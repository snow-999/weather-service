package com.example.weather_service.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class WeatherEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @JsonProperty("temp_c")
    private double tempC;
    @JsonProperty("temp_f")
    private double tempF;
    private String note;
    @JsonProperty("last_updated")
    private String date;
    @JsonProperty("wind_mph")
    private String windMPH;
    @JsonProperty("icon")
    private String icon;
    @JsonProperty("name")
    private String cityName;


    @Override
    public String toString() {
        return "temp is: " + this.getTempC() + " in f:";
    }
}


