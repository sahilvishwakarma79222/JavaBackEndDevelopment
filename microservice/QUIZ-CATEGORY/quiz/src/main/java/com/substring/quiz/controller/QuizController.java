package com.substring.quiz.controller;

import com.substring.quiz.dto.QuizDto;
import com.substring.quiz.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/quiz")
public class QuizController {

    private final QuizService service;
    public QuizController(QuizService service){
        this.service=service;
    }

    @PostMapping("/save")
    public ResponseEntity<?> saveQuiz(@RequestBody QuizDto quizDto){
        QuizDto dto = service.saveQuiz(quizDto);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }



}
