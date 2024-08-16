package com.example.java_travel_api.model.travel;

import java.time.LocalDate;
import java.util.List;


public record TravelReq(
        Long ownerId,
        int quantityPerson,
        List<Section> sections,
        boolean flightIncluded,
        List<Flight> flight,
        boolean hotelIncluded,
        List<Hotel> hotel,
        double budget,
        String currency,
        LocalDate dayStart,
        LocalDate dayReturn) {}
