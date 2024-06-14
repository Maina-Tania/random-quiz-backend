package com.quizexample.quizdemo.repository;

import com.quizexample.quizdemo.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Integer> {
}
