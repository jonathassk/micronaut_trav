package com.example.java_travel_api.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.example.java_travel_api.model.travel.Section;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SectionTravelRepository {

    private final DynamoDBMapper dynamoDBMapper;

    @Autowired
    public SectionTravelRepository(DynamoDBMapper dynamoDBMapper) {
        this.dynamoDBMapper = dynamoDBMapper;
    }

    public void save(Section section) {
        dynamoDBMapper.save(section);
    }

    public Section findById(Long id) {
        return dynamoDBMapper.load(Section.class, id);
    }

}
