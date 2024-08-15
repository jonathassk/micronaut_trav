package com.example.java_travel_api.interfaces;

import com.example.java_travel_api.model.Travel;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.travel.TravelReq;

public interface TravelService {
    void createTravel(TravelReq travel, User user);
    void includeTraveler(Travel travel, User admTraveler, String travelerId);
    void updateTravel(Travel travel, Long userId);
}
