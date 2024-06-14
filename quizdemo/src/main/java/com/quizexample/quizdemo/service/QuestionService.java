package com.quizexample.quizdemo.service;

import com.quizexample.quizdemo.model.Question;
import com.quizexample.quizdemo.repository.QuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class QuestionService {
    @Autowired
    QuestionRepository questionRepository;

    public Question addQuestion(Question question) {
        return questionRepository.save(question);
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<Question> getQuestionsByCategory(String category) {
        return questionRepository.findByCategory(category);
    }
    public  Question updateQuestion(Question question, Integer id){
        Optional<Question> existingQuestionOptional = questionRepository.findById(id);

        if (existingQuestionOptional.isPresent()) {
            Question existingQuestion = existingQuestionOptional.get();
            existingQuestion.setOption1(question.getOption1());
            existingQuestion.setOption2(question.getOption2());
            existingQuestion.setOption3(question.getOption3());
            existingQuestion.setOption4(question.getOption4());
            existingQuestion.setRightAnswer(question.getRightAnswer());
            existingQuestion.setQuestionTitle(question.getQuestionTitle());
            existingQuestion.setCategory(question.getCategory());
            existingQuestion.setDifficultyLevel(question.getDifficultyLevel());

            return questionRepository.save(existingQuestion);
        } else {
            throw new NoSuchElementException("Student with ID" + id + "not found" );
        }
    }
    public String deleteQuestion(Integer id){
        questionRepository.deleteById(id);
        return ("Student" + id + "removed") ;
    }
}
