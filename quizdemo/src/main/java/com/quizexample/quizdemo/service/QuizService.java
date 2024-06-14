package com.quizexample.quizdemo.service;

import com.quizexample.quizdemo.model.Question;
import com.quizexample.quizdemo.model.QuestionWrapper;
import com.quizexample.quizdemo.model.Quiz;
import com.quizexample.quizdemo.model.Response;
import com.quizexample.quizdemo.repository.QuestionRepository;
import com.quizexample.quizdemo.repository.QuizRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class QuizService {
    @Autowired
    QuizRepository quizRepository;

    @Autowired
    QuestionRepository questionRepository;

    public String createQuiz(String category, int numQ, String title) {
        List<Question> questions = questionRepository.findRandomQuestionByCategory(category, numQ);

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setQuestions(questions);
        quizRepository.save(quiz);

        return "success";
    }

    public List<QuestionWrapper> getQuizQuestions(Integer id) {
       Optional<Quiz> quiz = quizRepository.findById(id);
       List<Question> questionsFromDB = quiz.get().getQuestions();
       List<QuestionWrapper> questionsForUser = new ArrayList<>();
       for(Question q : questionsFromDB){
           QuestionWrapper qw = new QuestionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
           questionsForUser.add(qw);
       }
       return questionsForUser;
    }

    public Integer calculateResult(Integer id, List<Response> responses) {
        Quiz quiz = quizRepository.findById(id).get();
        List<Question> questions = quiz.getQuestions();
        Map<Integer, String> correctAnswers = new HashMap<>();

        // Store correct answers in a map
        for (Question question : questions) {
            correctAnswers.put(question.getId(), question.getRightAnswer());
        }

        int right = 0;
        for (Response response : responses) {
            Integer questionId = response.getId();
            String userAnswer = response.getResponse();

            // Check if the user's answer matches the correct answer
            if (correctAnswers.containsKey(questionId) && userAnswer.equals(correctAnswers.get(questionId))) {
                right++;
            }
        }

        return right;


    }
}
