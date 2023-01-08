package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.User;
import com.trivia.Trivia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody User newUser) {
        User createdUser = userRepository.save(newUser);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }
}
