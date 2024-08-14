package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PutMapping("/update")
    public ResponseEntity<RegisterReturn> updateUser(@RequestBody User user, @RequestHeader("Email") String email) {
        try {
            RegisterReturn result = userService.updateUser(user, email);
            return ResponseEntity.status(result.status()).body(result);
        } catch (DataIntegrityViolationException | IllegalArgumentException e) {
            RegisterReturn result = new RegisterReturn(null, e.getMessage(), HttpStatus.BAD_REQUEST);
            return ResponseEntity.status(400).body(result);
        } catch (Exception e) {
            RegisterReturn result = new RegisterReturn(null, e.getMessage(), null);
            return ResponseEntity.status(500).body(result);
        }
    }
}
