package com.substring.quiz.service;

import com.substring.quiz.collection.Quiz;
import com.substring.quiz.dto.QuizDto;

import java.util.List;

public interface QuizService {

    public QuizDto saveQuiz(QuizDto quiz);
    public List<QuizDto> getAllQuiz();
    public QuizDto findById(String quizId);
    public QuizDto updateQuiz(String quizId,QuizDto quizDto);
    public String deleteQuiz(String quizId);


}
