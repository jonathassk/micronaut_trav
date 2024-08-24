package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
import com.example.java_travel_api.utils.converters.DoubleConverter;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Hotel {
    @DynamoDBAttribute
    private String name;
    @DynamoDBAttribute
    private String city;
    @DynamoDBAttribute
    private String country;
    @DynamoDBAttribute
    private String address;
    @DynamoDBAttribute
    @DynamoDBTypeConverted(converter = DoubleConverter.class)
    private Double price;
}
