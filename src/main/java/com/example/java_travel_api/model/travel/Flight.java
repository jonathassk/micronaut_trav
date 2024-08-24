package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.java_travel_api.utils.converters.LocalDateTimeConverter;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor(force = true)
@AllArgsConstructor
@Builder
public class Flight {

    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime dateTimeDeparture;
    @DynamoDBAttribute
    private LocalDateTime dateTimeArrival;
    @DynamoDBAttribute
    private String origin; // origem e destino serao definidos codigo do aeroporto
    @DynamoDBAttribute
    private String destination;
    @DynamoDBAttribute
    private String airline;
    @DynamoDBAttribute
    private String flightNumber;
    @DynamoDBAttribute
    private String seatClass;
    @DynamoDBAttribute
    private double price;
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime returnDateTimeDeparture;
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = LocalDateTimeConverter.class)
    private LocalDateTime returnDateTimeArrival;
}
