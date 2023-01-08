package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.Questions;
import com.trivia.Trivia.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody Questions newQuestion) {
        Questions createdQuestion = questionRepository.save(newQuestion);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

}
