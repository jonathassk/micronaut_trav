package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public ResponseEntity<RegisterReturn> createUser(@Valid @RequestBody User user) {
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
