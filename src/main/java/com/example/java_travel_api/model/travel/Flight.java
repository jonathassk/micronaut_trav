package com.example.java_travel_api.model.travel;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Flight(
       LocalDateTime departure,
        LocalDateTime arrival,
        String origin,
        String destination,
        String airline,
        String flightNumber,
        String seatClass,
        double price,
        LocalDate returnDateDeparture,
        LocalDate returnDateArraival) {
}
