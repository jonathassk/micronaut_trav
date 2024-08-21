package com.example.java_travel_api.service;

import com.example.java_travel_api.interfaces.TravelService;
import com.example.java_travel_api.model.Travel;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.travel.JsonTravelResponse;
import com.example.java_travel_api.model.travel.TravelReq;
import com.example.java_travel_api.repository.TravelRepository;
import com.example.java_travel_api.repository.UserRepository;
import com.example.java_travel_api.utils.OpenAiRequests;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.CompletableFuture;

@Service
public class TravelServiceImpl implements TravelService {

    private final TravelRepository travelRepository;
    private final UserRepository userRepository;
    private final OpenAiRequests openAiRequests;

    public TravelServiceImpl(TravelRepository travelRepository, UserRepository userRepository, OpenAiRequests openAiRequests) {
        this.travelRepository = travelRepository;
        this.userRepository = userRepository;
        this.openAiRequests = openAiRequests;
    }

    @Override
    public void createTravel(TravelReq travelReq, User user) {
        Travel travel = createTravelObj(travelReq, user);
        // futuramente dividir em metodos de viagem unica e multiviagens

        CompletableFuture<JsonTravelResponse> openAiTravelFuture = CompletableFuture.supplyAsync(() -> {
            try {
                return sendTravelToOpenAiApi(travelReq);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        });
        openAiTravelFuture.thenAccept(this::sendToElasticSearch);
        CompletableFuture<Void> sqlFuture = CompletableFuture.runAsync(() -> saveInSql(user, travel));
        CompletableFuture.allOf(sqlFuture, openAiTravelFuture).join();
    }



    @Override
    public void includeTraveler(Travel travel, User admTraveler, String travelerId) {
        // TODO
    }

    @Override
    public void updateTravel(Travel travel, Long userId) {
        // TODO
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
        travel.setActive(true);
        travel.setTwoWay(travelReq.isTwoWay());
        return travel;
    }

    private void saveInSql(User user, Travel travel) {
        user.getTravels().add(travel);
        travelRepository.save(travel);
        userRepository.save(user);
    }

    private void sendToElasticSearch(JsonTravelResponse jsonTravelResponse) {
        // TODO
    }

    private JsonTravelResponse sendTravelToOpenAiApi(TravelReq travel) throws JsonProcessingException {
        Queue<String> travelInfo = new LinkedList<>();
        travelInfo.add(String.valueOf(travel.quantityPerson()));
        travelInfo.add(travel.sections().getFirst().getCity());
        travelInfo.add(travel.dayStart().toString());
        travelInfo.add(travel.dayReturn().toString());
        travelInfo.add(String.valueOf(travel.budget()));

        openAiRequests.sendRequestOpenAi(travelInfo);
        return null;
    }
}
