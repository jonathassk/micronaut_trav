package com.example.java_travel_api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.java_travel_api.model.travel.TravelPlan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class SectionTravelRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public SectionTravelRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void save(TravelPlan section) {
        dynamoDBMapper.save(section);
    }

    public TravelPlan findById(Long id) {
        return dynamoDBMapper.load(TravelPlan.class, id);
    }

}
