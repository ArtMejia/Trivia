package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Questions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Questions, Integer> {
}
