package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.java_travel_api.model.travel.Activities;
import com.example.java_travel_api.model.travel.ActivitiesTravel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class ActivitiesTravelConverter implements DynamoDBTypeConverter<String, List<ActivitiesTravel>> {

    private final ObjectMapper objectMapper;

    public ActivitiesTravelConverter (ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }
    @Override
    public String convert(List<ActivitiesTravel> activitiesTravels) {
        try {
            return objectMapper.writeValueAsString(activitiesTravels);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting weather section to string", e);
        }
    }

    @Override
    public List<ActivitiesTravel> unconvert(String string) {
        try {
            return objectMapper.readValue(string, List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting string to weather section", e);
        }
    }
}
