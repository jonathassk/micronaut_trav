package com.example.java_travel_api.model.travel;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Activities {
    @DynamoDBAttribute
    private String activity;
    @DynamoDBAttribute
    private double price;
    @DynamoDBAttribute
    private String address;
}
