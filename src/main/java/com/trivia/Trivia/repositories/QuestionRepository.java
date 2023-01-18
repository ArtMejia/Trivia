package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Integer> {
}
