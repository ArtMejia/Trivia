package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.Question;
import com.trivia.Trivia.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody Question newQuestion) {
        Question createdQuestion = questionRepository.save(newQuestion);
        return new ResponseEntity<>(createdQuestion, HttpStatus.CREATED);
    }

    @PostMapping("/{id}")
    public ResponseEntity<Question> updateQuestionById(@RequestBody Question questionData, @PathVariable Integer id) {
        Question question = questionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );

        if (questionData.getQuestion() != null) {
            question.setQuestion(questionData.getQuestion());
        }
        questionRepository.save(question);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllQuestions() {
        List<Question> allQuestions = questionRepository.findAll();
        return new ResponseEntity<>(allQuestions, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteQuestionById (@PathVariable Integer id) {
        Question question = questionRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        questionRepository.deleteById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }

}
