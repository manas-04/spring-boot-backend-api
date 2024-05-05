package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.WeatherInfoDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = WeatherInfoDeserializer.class)
public class WeatherInfo {
    private Long time;
    private Double currTemperature;
    private Double maxTemperature;
    private Double minTemperature;
    private Integer pressure;
    private Double humidity;
    private String weather;
    private String weatherDescription;
    private String weatherIcon;
    private Integer clouds;
    private Double windSpeed;
    private Integer windDegree;
    private Integer visibility;

}