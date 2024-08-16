package com.example.java_travel_api.model.travel;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "section")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Section {
    @Id
    private Long id;

    private LocalDate dayStart;
    private LocalDate dayEnd;
    private String city;
    private String country;
    private int quantityDailyActivities;
}
