package com.example.weather_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;



@Setter
@Getter
@Entity
public class WeatherEntity {
    private double tempC;
    private double tempF;
    @Id
    private long id;
    private String note;

    @Override
    public String toString() {
        return "temp is: " + this.getTempC() + " in f:";
    }
}


