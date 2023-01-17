package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername (String username);

//    @Override
//    User findById (Integer id);
}
