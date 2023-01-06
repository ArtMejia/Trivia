package com.trivia.Trivia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Profile {

    @Id
    private String username;
    private String password;
}
