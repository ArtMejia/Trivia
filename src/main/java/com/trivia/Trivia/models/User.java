package com.trivia.Trivia.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class User {

    @Id
    private String username;

    private String password;
    private String firstName;
    private String lastName;

}
