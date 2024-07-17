package com.microservice.store.web.controller;

import com.microservice.store.model.exception.SensorNotFoundException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(SensorNotFoundException.class)
    public String sensorNotFoundException (SensorNotFoundException e){
        return "Sensor not found";
    }

    @ExceptionHandler
    public String server(Exception e){
        e.printStackTrace();
        return "Something happened.";
    }
}
