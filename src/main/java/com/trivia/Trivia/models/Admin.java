package com.trivia.Trivia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Admin {
    @Id
    private String userName;

    private String password;
}
