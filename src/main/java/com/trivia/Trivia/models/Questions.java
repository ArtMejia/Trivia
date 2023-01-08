package com.trivia.Trivia.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Questions {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    private String question;

//    @OneToOne
//    private Options answer;

//    @OneToMany(mappedBy = "question")
//    private List<Options> choices;


    public Questions() {
    }

    public Questions(Integer id, String question) {
        this.id = id;
        this.question = question;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }
}
