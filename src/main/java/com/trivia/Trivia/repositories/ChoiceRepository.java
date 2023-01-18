package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChoiceRepository extends JpaRepository<Choice, Integer> {
}
