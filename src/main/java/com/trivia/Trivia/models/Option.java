package com.trivia.Trivia.models;

import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import jakarta.persistence.*;

@Entity
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String value;

    private boolean isAnswer;

    @ManyToOne
    @JoinColumn(name = "questions_id", referencedColumnName = "id")
    @JsonIncludeProperties("id")
    private Question question;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isAnswer() {
        return isAnswer;
    }

    public void setAnswer(boolean answer) {
        isAnswer = answer;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    public Option() { }

    public Option(Integer id, String value, boolean isAnswer, Question question) {
        this.id = id;
        this.value = value;
        this.isAnswer = isAnswer;
        this.question = question;
    }
}

/*
    Each question has 4 options
    Question: "What color is the sky?"
    Option 1: red   false
    Option 2: green false
    Option 3: white false
    Option 4: blue  true
 */