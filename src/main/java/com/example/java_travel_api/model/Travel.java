package com.example.java_travel_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
@Entity
@Table(name = "travels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Travel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne

    @JoinColumn(name = "user_id")
    private User user;

    @Column
    private int quantityPerson;

    @Column
    private String destination;

    @Column
    private boolean flightIncluded;

    @Column
    private String flight;

    @Column
    private boolean hotelIncluded;

    @Column
    private String hotel;

    @Column
    private double dailyBudget;

    @Column
    private String activities;

    @Column
    private String meals;

    @Column
    private LocalDate dayStart;

    @Column
    private LocalDate dayReturn;

    @Column
    private String cityCities;

    @Column
    private String countryCountries;


}
