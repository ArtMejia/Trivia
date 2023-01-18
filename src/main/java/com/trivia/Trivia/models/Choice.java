package com.trivia.Trivia.models;

import jakarta.persistence.*;

@Entity

public class Choice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String value;

    private boolean isAnswer;


    @ManyToOne
    @JoinColumn(name = "question_id", referencedColumnName = "id")

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

    public Choice() { }

    public Choice(Integer id, String value, boolean isAnswer, Question question) {
        this.id = id;
        this.value = value;
        this.isAnswer = isAnswer;
        this.question = question;
    }
}

/*
    Each question has 4 options
    Question: "What color is the sky?"
    Choice 1: red   false
    Choice 2: green false
    Choice 3: white false
    Choice 4: blue  true
 */