package com.example.java_travel_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

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

    @ManyToMany(mappedBy = "travels")
    private List<User> user;

    @Column
    private int quantityPerson;

    @Column
    private List<String> idSections;

    @Column
    private String origin;

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
    private LocalDate dayStart;

    @Column
    private LocalDate dayReturn;

    @Column
    private String createdAt;
}
