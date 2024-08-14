package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
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
            return ResponseEntity.status(400).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
