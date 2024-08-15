package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.TravelService;
import com.example.java_travel_api.model.Travel;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.travel.TravelReq;
import com.example.java_travel_api.repository.TravelRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;

    public TravelServiceImpl(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }

    @Override
    public void createTravel(TravelReq travelReq, User user) {
        List<User> userList = new ArrayList<>();


//        CompletableFuture<Void> sqlFuture = CompletableFuture.runAsync(() -> travelRepository.save(travel));
    }



    @Override
    public void includeTraveler(Travel travel, User admTraveler, String travelerId) {

    }

    @Override
    public void updateTravel(Travel travel, Long userId) {

    }

    private Travel createTravelObj() {
        return null;
    }
}
