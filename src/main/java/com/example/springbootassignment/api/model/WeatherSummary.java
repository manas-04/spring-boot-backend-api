package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.WeatherSummaryDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = WeatherSummaryDeserializer.class)
public class WeatherSummary {
    private String location;
    private Double latitude;
    private Double longitude;
    private String country;
    private String weather;
    private Double windSpeed;
    private Integer windDegree;
    private Integer pressure;
    private Integer humidity;
    private String weatherIcon;
    private Integer visibility;
    private Long sunrise;
    private Long sunset;
    private String weatherDescription;
    private Double minimumTemperature;
    private Double maximumTemperature;
}

