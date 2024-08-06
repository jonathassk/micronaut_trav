package com.example.java_travel_api.model;

import jakarta.persistence.*;
import lombok.*;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private
    Long id;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Size(min = 3, message = "name must be longer than 3!")
    private String firstname;

    @Column(nullable = false)
    @NotBlank
    @NotNull
    @Size(min = 3, message = "name must be longer than 3!")
    private String lastname;

    @Column(unique = true, nullable = false)
    @NotBlank
    @NotNull
    @Size(min = 8, message = "name must be longer than 8!")
    private String username;

    @Column(nullable = false)
    @Size(min = 8)
    private String password;

    @Column(unique = true, nullable = false)
    @Email(message = "email must be valid")
    private String email;

    @Column
    private
    String city;

    @Column
    private String country;

    @Column
    private String currency;

    @Column
    private int age;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Travel> travels;

}