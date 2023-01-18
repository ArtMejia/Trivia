package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Choice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Choice, Integer> {
}
