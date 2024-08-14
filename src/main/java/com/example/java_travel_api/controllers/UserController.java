package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.register.RegisterReturn;
import com.example.java_travel_api.model.User;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PutMapping("/update")
    public ResponseEntity<RegisterReturn> updateUser(@RequestBody User user) {
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            System.out.println("auth = " + authentication);
            RegisterReturn result = userService.updateUser(user);
            return ResponseEntity.status(result.status()).body(result);
        } catch (DataIntegrityViolationException | IllegalArgumentException e) {
            return ResponseEntity.status(400).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
