package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.HourlyWeatherDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = HourlyWeatherDeserializer.class)
public class HourlyWeather {

    private List<WeatherInfo> data;

    private String latitude;

    private String longitude;

    private String country;

    private Long sunrise;

    private Long sunset;

}