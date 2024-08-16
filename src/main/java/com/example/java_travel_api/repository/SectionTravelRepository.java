package com.example.java_travel_api.repository;

import com.example.java_travel_api.model.travel.Section;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SectionTravelRepository extends CrudRepository<Section, Long> {
}
