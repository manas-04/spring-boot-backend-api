package com.example.springbootassignment.api.model;

import com.example.springbootassignment.api.Deserialiser.WeatherSummaryDeserializer;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

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

  // Getter and Setter for location
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  // Getter and Setter for latitude
  public Double getLatitude() {
    return latitude;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  // Getter and Setter for longitude
  public Double getLongitude() {
    return longitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  // Getter and Setter for country
  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  // Getter and Setter for weather
  public String getWeather() {
    return weather;
  }

  public void setWeather(String weather) {
    this.weather = weather;
  }

  // Getter and Setter for weatherDescription
  public String getWeatherDescription() {
    return weatherDescription;
  }

  public void setWeatherDescription(String weatherDescription) {
    this.weatherDescription = weatherDescription;
  }

  // Getter and Setter for minimumTemperature
  public Double getMinimumTemperature() {
    return minimumTemperature;
  }

  public void setMinimumTemperature(Double minimumTemperature) {
    this.minimumTemperature = minimumTemperature;
  }

  // Getter and Setter for maximumTemperature
  public Double getMaximumTemperature() {
    return maximumTemperature;
  }

  public void setMaximumTemperature(Double maximumTemperature) {
    this.maximumTemperature = maximumTemperature;
  }

  // Getter and Setter for windSpeed
  public Double getWindSpeed() {
    return windSpeed;
  }

  public void setWindSpeed(Double windSpeed) {
    this.windSpeed = windSpeed;
  }

  // Getter and Setter for windDegree
  public Integer getWindDegree() {
    return windDegree;
  }

  public void setWindDegree(Integer windDegree) {
    this.windDegree = windDegree;
  }

  // Getter and Setter for pressure
  public Integer getPressure() {
    return pressure;
  }

  public void setPressure(Integer pressure) {
    this.pressure = pressure;
  }

  // Getter and Setter for humidity
  public Integer getHumidity() {
    return humidity;
  }

  public void setHumidity(Integer humidity) {
    this.humidity = humidity;
  }

  // Getter and Setter for weatherIcon
  public String getWeatherIcon() {
    return weatherIcon;
  }

  public void setWeatherIcon(String weatherIcon) {
    this.weatherIcon = weatherIcon;
  }

  // Getter and Setter for visibility
  public Integer getVisibility() {
    return visibility;
  }

  public void setVisibility(Integer visibility) {
    this.visibility = visibility;
  }

  public Long getSunrise() {
    return sunrise;
  }

  public void setSunrise(Long sunrise) {
    this.sunrise = sunrise;
  }

  // Getter and Setter for sunset
  public Long getSunset() {
    return sunset;
  }

  public void setSunset(Long sunset) {
    this.sunset = sunset;
  }
}

