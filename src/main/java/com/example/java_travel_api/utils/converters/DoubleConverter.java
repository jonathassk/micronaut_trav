package com.example.java_travel_api.utils.converters;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverter;

public class DoubleConverter implements DynamoDBTypeConverter<String, Double> {
    @Override
    public String convert(Double aDouble) {
        return aDouble.toString();
    }

    @Override
    public Double unconvert(String s) {
        return Double.parseDouble(s);
    }
}
