package com.trivia.Trivia.controllers;

import com.trivia.Trivia.models.Choice;
import com.trivia.Trivia.repositories.OptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/answer")
public class OptionController {

    @Autowired
    private OptionRepository optionRepository;

    @PostMapping()
    public ResponseEntity<?> createQuestionWithOptions(@RequestBody Choice newChoice) {

        Choice createChoice = optionRepository.save(newChoice);

        return new ResponseEntity<>(createChoice,  HttpStatus.CREATED);

    }
}
