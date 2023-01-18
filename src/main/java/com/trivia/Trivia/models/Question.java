package com.trivia.Trivia.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String question;

    @OneToMany(mappedBy = "question")
    private List<Option> choices;

    public Question() {
    }

    public Question(Integer id, String question, List<Option> choices) {
        this.id = id;
        this.question = question;
        this.choices = choices;
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

    public List<Option> getChoices() {
        return choices;
    }

    public void setChoices(List<Option> choices) {
        this.choices = choices;
    }
}
