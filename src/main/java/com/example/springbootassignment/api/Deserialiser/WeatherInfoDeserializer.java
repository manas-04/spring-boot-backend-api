package com.example.springbootassignment.api.Deserialiser;

import com.example.springbootassignment.api.model.WeatherInfo;
import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class WeatherInfoDeserializer extends StdDeserializer<WeatherInfo> {
    protected WeatherInfoDeserializer() {
        super(WeatherInfo.class);
    }
    protected WeatherInfoDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public WeatherInfo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
        WeatherInfo weatherData = new WeatherInfo();
        weatherData.setTime(node.get("dt").asLong());
        weatherData.setCurrTemperature(node.get("main").get("temp").asDouble());
        weatherData.setMaxTemperature(node.get("main").get("temp_max").asDouble());
        weatherData.setMinTemperature(node.get("main").get("temp_min").asDouble());
        weatherData.setPressure(node.get("main").get("pressure").asInt());
        weatherData.setHumidity(node.get("main").get("humidity").asDouble());
        weatherData.setWeather(node.get("weather").get(0).get("main").asText());
        weatherData.setWeatherDescription(node.get("weather").get(0).get("main").asText());
        weatherData.setWeatherIcon(node.get("weather").get(0).get("icon").asText());
        weatherData.setClouds(node.get("clouds").get("all").asInt());
        weatherData.setWindSpeed(node.get("wind").get("speed").asDouble());
        weatherData.setWindDegree(node.get("wind").get("deg").asInt());
        weatherData.setVisibility(node.get("visibility").asInt());

        return weatherData;
    }
}