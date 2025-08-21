package com.example.weather_service.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@Entity
public class WeatherEntity {
    @Id
    private long id;
    private double tempC;
    private double tempF;
    private String note;
    private String date;


    @Override
    public String toString() {
        return "temp is: " + this.getTempC() + " in f:";
    }
}


