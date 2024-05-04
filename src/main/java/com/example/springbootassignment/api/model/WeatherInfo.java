package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.WeatherInfoDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

    // Getters
    public Long getTime() {
        return time;
    }

    public Double getCurrTemperature() {
        return currTemperature;
    }

    public Double getMaxTemperature() {
        return maxTemperature;
    }

    public Double getMinTemperature() {
        return minTemperature;
    }

    public Integer getPressure() {
        return pressure;
    }

    public Double getHumidity() {
        return humidity;
    }

    public String getWeather() {
        return weather;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public Integer getClouds() {
        return clouds;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Integer getWindDegree() {
        return windDegree;
    }

    public Integer getVisibility() {
        return visibility;
    }

    // Setters
    public void setTime(Long time) {
        this.time = time;
    }

    public void setCurrTemperature(Double currTemperature) {
        this.currTemperature = currTemperature;
    }

    public void setMaxTemperature(Double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public void setMinTemperature(Double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public void setPressure(Integer pressure) {
        this.pressure = pressure;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }

    public void setClouds(Integer clouds) {
        this.clouds = clouds;
    }

    public void setWindSpeed(Double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public void setWindDegree(Integer windDegree) {
        this.windDegree = windDegree;
    }

    public void setVisibility(Integer visibility) {
        this.visibility = visibility;
    }
}