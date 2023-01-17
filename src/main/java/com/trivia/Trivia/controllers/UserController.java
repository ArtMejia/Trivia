package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.User;
import com.trivia.Trivia.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteByUsername(@PathVariable Integer id) {
        User requestedUser = userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        userRepository.deleteById(id);
        return new ResponseEntity<>(requestedUser, HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateByUsername(@PathVariable Integer id, @RequestBody User updatedUserData) {
        User requestedUser = userRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        if (!updatedUserData.getUsername().equals("")) {
            requestedUser.setUsername(updatedUserData.getUsername());
        }
        if (!updatedUserData.getPassword().equals("")) {
            requestedUser.setPassword(updatedUserData.getPassword());
        }
        if (!updatedUserData.getFirstName().equals("")) {
            requestedUser.setFirstName(updatedUserData.getFirstName());
        }
        if (!updatedUserData.getLastName().equals("")) {
            requestedUser.setLastName(updatedUserData.getLastName());
        }
        userRepository.save(requestedUser);
        return new ResponseEntity<>(requestedUser, HttpStatus.OK);
    }

}
