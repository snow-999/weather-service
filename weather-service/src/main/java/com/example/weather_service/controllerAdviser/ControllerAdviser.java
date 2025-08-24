package com.example.weather_service.controllerAdviser;

import com.example.weather_service.dto.ErrorModel;
import com.example.weather_service.exception.CItyNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ControllerAdviser {
    @ExceptionHandler(CItyNotFound.class)
    public ResponseEntity<ErrorModel> cityNotFoundException (CItyNotFound ex) {
        ErrorModel errorModel = new ErrorModel(ex.getMessage());
        return new ResponseEntity<>(errorModel, HttpStatus.NOT_FOUND);
    }

}
