package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.TravelService;
import com.example.java_travel_api.model.Travel;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.travel.TravelReq;
import com.example.java_travel_api.repository.TravelRepository;
import com.example.java_travel_api.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final UserRepository userRepository;

    public TravelServiceImpl(TravelRepository travelRepository, UserRepository userRepository) {
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTravel(TravelReq travelReq, User user) {
        Travel travel = createTravelObj(travelReq, user);
        user.getTravels().add(travel);
        travelRepository.save(travel);
        userRepository.save(user);
//      CompletableFuture<Void> sqlFuture = CompletableFuture.runAsync(() -> travelRepository.save(travel));
    }



    @Override
    public void includeTraveler(Travel travel, User admTraveler, String travelerId) {

    }

    @Override
    public void updateTravel(Travel travel, Long userId) {

    }

    private Travel createTravelObj(TravelReq travelReq, User user) {
        Travel travel = new Travel();
        travel.setUser(List.of(user));
        travel.setQuantityPerson(travelReq.quantityPerson());
        travel.setIdSections(UUID.randomUUID());
        travel.setFlightIncluded(travelReq.flightIncluded());
        travel.setHotelIncluded(travelReq.flightIncluded());
        travel.setBudget(travelReq.budget());
        travel.setCurrency("USD");
        travel.setDayStart(travelReq.dayStart());
        travel.setDayReturn(travelReq.dayReturn());
        travel.setActive(true);
        travel.setCreatedAt(LocalDateTime.now());
        return travel;
    }
}
