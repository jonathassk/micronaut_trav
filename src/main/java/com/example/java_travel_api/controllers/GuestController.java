package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guests")
public class GuestController {

    private final UserService userService;

    public GuestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create-user")
    public ResponseEntity<RegisterReturn> createUser(@RequestBody User user) {
        try {
            RegisterReturn result = userService.createUser(user);
            return ResponseEntity.status(result.status()).body(result);
        } catch (DataIntegrityViolationException | IllegalArgumentException e) {
            return ResponseEntity.status(400).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
