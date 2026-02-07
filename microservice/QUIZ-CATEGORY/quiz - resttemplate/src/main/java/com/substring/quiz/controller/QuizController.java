package com.substring.quiz.controller;

import com.substring.quiz.collection.Quiz;
import com.substring.quiz.dto.QuizDto;
import com.substring.quiz.service.QuizService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("/{quizId}")
    public ResponseEntity<?> getById(@PathVariable String quizId){
        QuizDto singleQuiz = service.findById(quizId);
        return new ResponseEntity<>(singleQuiz,HttpStatus.OK);
    }

    @PutMapping("/update/{quizId}")
    public ResponseEntity<?> updateQuiz(@PathVariable String quizId, @RequestBody QuizDto quiz){
        QuizDto quizDto = service.updateQuiz(quizId, quiz);
        return new ResponseEntity<>(quizDto,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{quizId}")
    public ResponseEntity<?> deleteQuizByQuizId(@PathVariable String quizId){
        String msg = service.deleteQuiz(quizId);
        return new ResponseEntity<>(msg,HttpStatus.OK);
    }

    @GetMapping("/allQuiz")
    public ResponseEntity<?> getAllQuiz(){
        List<QuizDto> allQuiz = service.getAllQuiz();
        return new ResponseEntity<>(allQuiz,HttpStatus.OK);
    }


}
