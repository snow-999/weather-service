package com.example.weather_service.repository;

import com.example.weather_service.entity.WeatherEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherEntity, Long> {
    @Query(value = "SELECT note FROM weather_entity", nativeQuery = true)
    List<String> selectNoteFromWeatherEntity();
}
