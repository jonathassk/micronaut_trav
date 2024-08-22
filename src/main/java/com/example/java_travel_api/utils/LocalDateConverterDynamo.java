package com.example.java_travel_api.utils;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

import java.time.LocalDate;

public class LocalDateConverterDynamo implements DynamoDBTypeConverter<String, LocalDate> {
    @Override
    public String convert(LocalDate localDate) {
        return localDate.toString();
    }

    @Override
    public LocalDate unconvert(String s) {
        return LocalDate.parse(s);
    }
}