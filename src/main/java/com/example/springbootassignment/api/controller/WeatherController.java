package com.example.springbootassignment.api.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springbootassignment.service.WeatherService;

import java.util.Arrays;

@CrossOrigin
@RestController
public class WeatherController {

    Logger logger = LoggerFactory.getLogger(WeatherController.class);

    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather/hourly-update/{city}")
    public ResponseEntity<Object> hourlyWeather(@PathVariable String city) {
        try {
            if (city == null || city.isBlank()) {
                return ResponseEntity.badRequest().body("City field is empty");
            }
            return this.weatherService.fetchHourlyForecast(city);
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().body("Internal server error: " + e.getMessage());
        }
    }

    @GetMapping("/weather/summary/{city}")
    public ResponseEntity<Object> forecastSummary(@PathVariable String city) {
        try {
            if (city == null || city.isBlank()) {
                return ResponseEntity.badRequest().body("City field is empty");
            }
            return this.weatherService.fetchForecastSummary(city);
        } catch (Exception e) {
            logger.error(Arrays.toString(e.getStackTrace()));
            return ResponseEntity.internalServerError().body("Internal server error: " + e.getMessage());
        }
    }
}