package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Option;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OptionRepository extends JpaRepository<Option, Integer> {
}
