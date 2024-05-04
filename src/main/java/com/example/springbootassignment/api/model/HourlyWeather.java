package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.HourlyWeatherDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonDeserialize(using = HourlyWeatherDeserializer.class)
public class HourlyWeather {

    private List<WeatherInfo> data;

    private String latitude;

    private String longitude;

    private String country;

    private Long sunrise;

    private Long sunset;

    public List<WeatherInfo> getData() {
        return data;
    }

    public void setData(List<WeatherInfo> data) {
        this.data = data;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getSunrise() {
        return sunrise;
    }

    public void setSunrise(Long sunrise) {
        this.sunrise = sunrise;
    }

    public Long getSunset() {
        return sunset;
    }

    public void setSunset(Long sunset) {
        this.sunset = sunset;
    }
}