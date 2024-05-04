package com.example.springbootassignment.api.Deserialiser;

import com.example.springbootassignment.api.model.HourlyWeather;
import com.example.springbootassignment.api.model.WeatherInfo;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class HourlyWeatherDeserializer extends JsonDeserializer<HourlyWeather> {

    @Override
    public HourlyWeather deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        JsonNode node = jsonParser.getCodec().readTree(jsonParser);

        List<WeatherInfo> data = new ArrayList<>();
        JsonNode dataNode = node.get("list");
        if (dataNode != null && dataNode.isArray()) {
            for (JsonNode weatherNode : dataNode) {
                ObjectMapper objectMapper = new ObjectMapper();
                WeatherInfo temp = objectMapper.readValue(objectMapper.writeValueAsString(weatherNode), WeatherInfo.class);
                data.add(temp);
            }
        }

        HourlyWeather hourlyWeather = new HourlyWeather();
        hourlyWeather.setData(data);
        hourlyWeather.setLatitude(node.get("city").get("coord").get("lat").asText());
        hourlyWeather.setLongitude(node.get("city").get("coord").get("lon").asText());
        hourlyWeather.setCountry(node.get("city").get("country").asText());
        hourlyWeather.setSunrise(node.get("city").get("sunrise").asLong());
        hourlyWeather.setSunset(node.get("city").get("sunset").asLong());

        return hourlyWeather;
    }
}
