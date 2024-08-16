package com.example.java_travel_api.model.travel;

import java.time.LocalDate;

public record Section(Long id, LocalDate dayStart, LocalDate dayEnd, String city, String country, int quantityDailyActivities) {
}
