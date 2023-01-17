package com.trivia.Trivia.controllers;

import com.sun.net.httpserver.HttpsServer;
import com.trivia.Trivia.models.Admin;
import com.trivia.Trivia.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping("/{id}")
    public ResponseEntity<Admin> updateAdmin(@PathVariable String id, @RequestBody Admin updateAdminData) {
        Admin adminUpdate = adminRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        if(!updateAdminData.getPassword().equals("")){
            adminUpdate.setPassword((updateAdminData.getPassword()));
        }

        adminRepository.save(adminUpdate);

        return new ResponseEntity<>(adminUpdate, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Admin> deleteAdmin(@PathVariable String id) {
        Admin adminRequest = adminRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        adminRepository.deleteById(id);

        return new ResponseEntity<>(adminRequest, HttpStatus.OK);
    }
}
