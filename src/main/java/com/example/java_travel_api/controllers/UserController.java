package com.example.java_travel_api.controllers;

import com.example.java_travel_api.interfaces.UserService;
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
    public ResponseEntity<?> createUser(@Valid @RequestBody User user) {
        try {
            userService.createUser(user);
            return ResponseEntity.status(201).body(user); // Retorna 201 em caso de sucesso
        } catch (DataIntegrityViolationException e) {
        return ResponseEntity.status(400).body("Erro: Já existe um usuário com este email.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        } catch (Exception e) { // Captura qualquer outra exceção inesperada
            return ResponseEntity.status(500).body("Erro interno do servidor.");
        }
    }
}
