package com.example.java_travel_api.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

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
    private UUID idSections;

    @Column
    private boolean flightIncluded;
    @Column
    private String origin;

    @Column
    private boolean hotelIncluded;

    @Column
    private double budget;

    @Column
    private String currency;

    @Column
    private LocalDate dayStart;

    @Column
    private LocalDate dayReturn;

    @Column
    private boolean isTwoWay;

    @Column
    private boolean active;

    @Column
    private LocalDateTime createdAt;
}
