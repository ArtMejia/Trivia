package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.Admin;
import com.trivia.Trivia.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    @Autowired
    private AdminRepository adminRepository;

    @PostMapping
    public ResponseEntity<?> createAdmin(@RequestBody Admin newAdmin) {

        Admin createdAdmin = adminRepository.save(newAdmin);

        return new ResponseEntity<>(createdAdmin, HttpStatus.CREATED);

    }

    @GetMapping()
    public ResponseEntity<?> getAllAdmin() {
        List<Admin> allAdmins = adminRepository.findAll();

        return new ResponseEntity<>(allAdmins, HttpStatus.OK);
    }
}
