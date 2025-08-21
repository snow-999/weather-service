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
    private double temp_c;
    private double temp_f;

    @Id
    private long id;


    @Override
    public String toString() {
        return "temp is: " + this.getTemp_c() + " in f:";
    }
}


