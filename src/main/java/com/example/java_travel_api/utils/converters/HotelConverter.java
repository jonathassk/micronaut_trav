package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.java_travel_api.model.travel.Flight;
import com.example.java_travel_api.model.travel.Hotel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class HotelConverter implements DynamoDBTypeConverter<String, List<Hotel>> {

    private final ObjectMapper objectMapper;

    public HotelConverter(ObjectMapper objectMapper) {
        objectMapper.registerModule(new JavaTimeModule());
        this.objectMapper = objectMapper;
    }

    @Override
    public String convert(List<Hotel> hotelList) {
        try {
            return objectMapper.writeValueAsString(hotelList);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Hotel> unconvert(String string) {
        try {
            return objectMapper.readValue(string, new TypeReference<List<Hotel>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
