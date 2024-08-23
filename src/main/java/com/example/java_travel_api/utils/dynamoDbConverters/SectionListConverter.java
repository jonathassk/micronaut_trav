package com.example.java_travel_api.utils.dynamoDbConverters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;
import com.example.java_travel_api.model.travel.Section;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.util.List;

public class SectionListConverter implements DynamoDBTypeConverter<String, List<Section>> {

    private final ObjectMapper objectMapper;

    public SectionListConverter() {
        this.objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public String convert(List<Section> sections) {
        try {
            return objectMapper.writeValueAsString(sections);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting list of sections to string", e);
        }
    }

    @Override
    public List<Section> unconvert(String sectionsString) {
        try {
            return objectMapper.readValue(sectionsString, new TypeReference<List<Section>>() {});
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error converting string to list of sections", e);
        }
    }
}
