package com.quizexample.quizdemo.repository;

import com.quizexample.quizdemo.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Integer> {
    List<Question> findByCategory(String category);

    @Query(value = "SELECT * FROM question q WHERE q.category= ? ORDER BY RAND() LIMIT ?", nativeQuery = true)
    List<Question> findRandomQuestionByCategory(String category, int numQ);
}
