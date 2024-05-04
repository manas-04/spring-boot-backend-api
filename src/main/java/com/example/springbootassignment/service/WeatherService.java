package com.example.springbootassignment.service;

import com.example.springbootassignment.api.model.HourlyWeather;
import com.example.springbootassignment.api.model.WeatherSummary;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {
    @Value("${springBootAssignment.apiKey}")
    private String apiKey;

    private final String hourlyForecastUrl;
    private final String forecastSummaryUrl;
    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    Logger logger = LoggerFactory.getLogger(WeatherService.class);

    public WeatherService() {
        this.restTemplate = new RestTemplate();
        this.objectMapper = new ObjectMapper();
        this.hourlyForecastUrl = "https://api.openweathermap.org/data/2.5/forecast?q={location}&appid={apiKey}";
        this.forecastSummaryUrl = "https://api.openweathermap.org/data/2.5/weather?q={location}&appid={apiKey}";
    }

    private String replaceUrl(String locationName, String url) {
        return url.replace("{location}", locationName)
                .replace("{apiKey}", this.apiKey);
    }

    public ResponseEntity<Object> makeRestRequest(String location, String url, boolean isHourlyData) {
        try {
            String replacedUrl = replaceUrl(location, url);
            ResponseEntity<String> responseEntity = restTemplate.getForEntity(replacedUrl, String.class);

            String json = responseEntity.getBody();
            WeatherSummary weatherData;
            HourlyWeather hourlyWeather;

            if(isHourlyData){
                hourlyWeather = objectMapper.readValue(json, HourlyWeather.class);
                return ResponseEntity.ok(hourlyWeather);
            }else{
                weatherData = objectMapper.readValue(json, WeatherSummary.class);
                return ResponseEntity.ok(weatherData);
            }

        } catch (HttpClientErrorException e){
            String errorMessage = e.getMessage();
            logger.error("Error processing Http client response", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        } catch (JsonProcessingException e) {
            String errorMessage = e.getMessage();
            logger.error("Error processing JSON response", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage); // Or throw a custom exception
        } catch (RestClientException e) {
            String errorMessage = e.getMessage();
            logger.error("Error executing REST request", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
        }
    }

    public ResponseEntity<Object> fetchHourlyForecast(String location) {
        return makeRestRequest(location, this.hourlyForecastUrl, true);
    }

    public ResponseEntity<Object> fetchForecastSummary(String location) {
        return makeRestRequest(location, this.forecastSummaryUrl, false);
    }

}