package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.java_travel_api.model.travel.Flight;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class FlightConverter implements DynamoDBTypeConverter<String, List<Flight>> {

    private final ObjectMapper objectMapper;

    public FlightConverter (ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String convert(List<Flight> flights) {
        try {
            return objectMapper.writeValueAsString(flights);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Flight> unconvert(String s) {
        try {
            return objectMapper.readValue(s, new TypeReference<List<Flight>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

}
