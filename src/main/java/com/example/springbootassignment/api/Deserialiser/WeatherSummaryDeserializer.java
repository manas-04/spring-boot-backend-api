package com.example.springbootassignment.api.Deserialiser;

import com.example.springbootassignment.api.model.WeatherSummary;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class WeatherSummaryDeserializer extends StdDeserializer<WeatherSummary> {
    protected WeatherSummaryDeserializer() {
        super(WeatherSummary.class);
    }
    protected WeatherSummaryDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherSummary deserialize(JsonParser jp, DeserializationContext ctxt)
            throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);

        WeatherSummary weatherData = new WeatherSummary();

        weatherData.setLocation(node.get("name").asText());
        weatherData.setLatitude(node.get("coord").get("lat").asDouble());
        weatherData.setLongitude(node.get("coord").get("lon").asDouble());
        weatherData.setCountry(node.get("sys").get("country").asText());
        weatherData.setWeather(node.get("weather").get(0).get("main").asText());
        weatherData.setWeatherDescription(node.get("weather").get(0).get("description").asText());
        weatherData.setMinimumTemperature(node.get("main").get("temp_min").asDouble());
        weatherData.setMaximumTemperature(node.get("main").get("temp_max").asDouble());
        weatherData.setWindSpeed(node.get("wind").get("speed").asDouble());
        weatherData.setWindDegree(node.get("wind").get("deg").asInt());
        weatherData.setPressure(node.get("main").get("pressure").asInt());
        weatherData.setHumidity(node.get("main").get("humidity").asInt());
        weatherData.setWeatherIcon(node.get("weather").get(0).get("icon").asText());
        weatherData.setVisibility(node.get("visibility").asInt());
        weatherData.setSunrise(node.get("sys").get("sunrise").asLong());
        weatherData.setSunset(node.get("sys").get("sunset").asLong());

        return weatherData;
    }
}