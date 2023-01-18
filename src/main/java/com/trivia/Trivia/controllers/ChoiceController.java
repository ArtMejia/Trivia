package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.Choice;
import com.trivia.Trivia.models.Question;
import com.trivia.Trivia.repositories.ChoiceRepository;
import com.trivia.Trivia.repositories.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("api/choices")
public class ChoiceController {

    @Autowired
    private ChoiceRepository choiceRepository;

    @Autowired
    private QuestionRepository questionRepository;

    @PostMapping("/{id}")
    public ResponseEntity<?> createChoice(@RequestBody Choice newChoice, @PathVariable Integer id) {
        Question requestedQuestion = questionRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        requestedQuestion.addChoiceToList(newChoice);
        Choice createChoice = choiceRepository.save(newChoice);
        return new ResponseEntity<>(createChoice,  HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteChoice(@PathVariable Integer id) {
        Choice requestedChoice = choiceRepository.findById(id).orElseThrow(
                ()-> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
        choiceRepository.deleteById(id);
        return new ResponseEntity<>(requestedChoice, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllChoices() {
        List<Choice> allChoices = choiceRepository.findAll();
        return new ResponseEntity<>(allChoices, HttpStatus.OK);
    }



}
