package com.example.java_travel_api.controllers;

import com.example.java_travel_api.model.User;
import com.example.java_travel_api.model.register.RegisterReturn;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeController {

    @GetMapping
    public String getController() {
        return "teste";
    }

    @PostMapping("/update")
    public ResponseEntity<RegisterReturn> updateUser(@RequestBody User user) {
        System.out.println(user.toString());
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        System.out.println(authentication);
        return ResponseEntity.status(200).body(null);
        //RegisterReturn result = userService.updateUser(user);
        //return ResponseEntity.status(result.status()).body(result);
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

}
