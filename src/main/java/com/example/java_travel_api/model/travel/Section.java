package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.java_travel_api.utils.converters.FlightConverter;
import com.example.java_travel_api.utils.converters.HotelConverter;
import com.example.java_travel_api.utils.converters.LocalDateConverter;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate dayStart;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateConverter.class)
    private LocalDate dayEnd;

    @DynamoDBAttribute
    private String city;

    @DynamoDBAttribute
    private String country;

    @DynamoDBAttribute
    private String cityId;

    @DynamoDBAttribute
    private int quantityDailyActivities;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = FlightConverter.class)
    private List<Flight> flights;

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = HotelConverter.class)
    private List<Hotel> hotels;
}
