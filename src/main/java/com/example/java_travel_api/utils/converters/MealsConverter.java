package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class MealsConverter implements DynamoDBTypeConverter<String, List> {

    private final ObjectMapper objectMapper;

    public MealsConverter(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public String convert(List activitiesList) {
        try {
            return objectMapper.writeValueAsString(activitiesList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting activities list to string", e);
        }
    }

    @Override
    public List unconvert(String string) {
        try {
            return objectMapper.readValue(string, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting string to activities list", e);
        }
    }
}
