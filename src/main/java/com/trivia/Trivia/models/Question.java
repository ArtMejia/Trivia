package com.trivia.Trivia.models;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String question;

    @OneToMany
    @JoinColumn(name = "option_id", referencedColumnName = "id")
    private List<Choice> choices;

    public Question() {
    }

    public Question(Integer id, String question, List<Choice> choices) {
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

    public List<Choice> getChoices() {
        return choices;
    }

    public void setChoices(List<Choice> choices) {
        this.choices = choices;
    }

    public void addChoiceToList(Choice choice) {
        this.choices.add(choice);
    }
}
