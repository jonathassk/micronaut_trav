package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;

public class WeatherSection {
    @DynamoDBAttribute
    private String month;
    @DynamoDBAttribute
    private String temperature;
    @DynamoDBAttribute
    private String humidity;
    @DynamoDBAttribute
    private String precipitation;
}
