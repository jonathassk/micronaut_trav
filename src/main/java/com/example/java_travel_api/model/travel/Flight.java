package com.example.java_travel_api.model.travel;

import org.springframework.cglib.core.Local;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record Flight(LocalDateTime departure, LocalDateTime arrival, String origin, String destination, String airline, String flightNumber, String seatClass, double price, LocalDate returnDateDeparture, Local returnDateArraival) {
}
