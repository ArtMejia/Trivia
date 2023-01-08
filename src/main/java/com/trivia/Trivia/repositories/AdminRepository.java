package com.trivia.Trivia.repositories;

import com.trivia.Trivia.models.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String > {
}
