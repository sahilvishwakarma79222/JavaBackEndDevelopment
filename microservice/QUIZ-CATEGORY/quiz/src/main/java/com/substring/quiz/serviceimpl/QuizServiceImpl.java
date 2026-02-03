package com.substring.quiz.serviceimpl;

import com.substring.quiz.collection.Quiz;
import com.substring.quiz.dto.QuizDto;
import com.substring.quiz.repository.QuizRepository;
import com.substring.quiz.service.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {


    private final ModelMapper modelMapper;
    private final QuizRepository quizRepository;
    public QuizServiceImpl(ModelMapper modelMapper,
                           QuizRepository quizRepository){
        this.modelMapper=modelMapper;
        this.quizRepository=quizRepository;
    }


    @Override
    public QuizDto saveQuiz(QuizDto quiz) {
        Quiz entity = modelMapper.map(quiz, Quiz.class);
        Quiz save = quizRepository.save(entity);
        return modelMapper.map(save,QuizDto.class);
    }

    @Override
    public List<QuizDto> getAllQuiz() {

        List<Quiz> all = quizRepository.findAll();
        List<QuizDto> allQuiz = all.stream().map(q -> modelMapper.map(q, QuizDto.class)).toList();
        return allQuiz;
    }

    @Override
    public QuizDto findById(String quizId) {

        Optional<Quiz> quiz = quizRepository.findById(quizId);
        Optional<QuizDto> quizDto = quiz.map(q -> modelMapper.map(q, QuizDto.class));
        return quizDto.get();
    }

    @Override
    public QuizDto updateQuiz(String quizId,QuizDto quizDto) {

        quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("quiz Not Found With id " + quizId));
        quizDto.setId(quizId);
        Quiz quiz = modelMapper.map(quizDto, Quiz.class);
        Quiz save = quizRepository.save(quiz);
        return modelMapper.map(save,QuizDto.class);
    }

    @Override
    public String deleteQuiz(String quizId) {
        quizRepository.findById(quizId).orElseThrow(() -> new RuntimeException("quiz Not Found With id " + quizId));
        quizRepository.deleteById(quizId);
        return "Succesfully deleted the quiz with id "+quizId;
    }
}
