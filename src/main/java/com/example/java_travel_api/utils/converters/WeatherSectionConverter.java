package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.java_travel_api.model.travel.WeatherSection;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class WeatherSectionConverter implements DynamoDBTypeConverter<String, WeatherSection> {

    private final ObjectMapper objectMapper;

    public WeatherSectionConverter(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper = objectMapper;
    }


    @Override
    public String convert(WeatherSection weatherSection) {
        try {
            return objectMapper.writeValueAsString(weatherSection);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting weather section to string", e);
        }
    }

    @Override
    public WeatherSection unconvert(String string) {
        try {
            return objectMapper.readValue(string, WeatherSection.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting string to weather section", e);
        }
    }
}
