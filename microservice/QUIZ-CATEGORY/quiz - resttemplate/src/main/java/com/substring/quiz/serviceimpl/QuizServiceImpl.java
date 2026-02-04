package com.substring.quiz.serviceimpl;

import com.substring.quiz.collection.Quiz;
import com.substring.quiz.dto.CategoryDto;
import com.substring.quiz.dto.QuizDto;
import com.substring.quiz.repository.QuizRepository;
import com.substring.quiz.service.CategoryService;
import com.substring.quiz.service.QuizService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class QuizServiceImpl implements QuizService {


    private final ModelMapper modelMapper;
    private final QuizRepository quizRepository;
    private final CategoryService categoryService;
    public QuizServiceImpl(ModelMapper modelMapper,
                           QuizRepository quizRepository,
                           CategoryService categoryService){
        this.modelMapper=modelMapper;
        this.quizRepository=quizRepository;
        this.categoryService=categoryService;
    }

    @Override
    public QuizDto saveQuiz(QuizDto quiz) {
        if(quiz.getCategoryId()!=null || !(quiz.getCategoryId().isEmpty())){
            CategoryDto byCategoryId = categoryService.findByCategoryId((quiz.getCategoryId()));
        }
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
        QuizDto quizDto = quiz.map(q -> modelMapper.map(q, QuizDto.class)).get();

        try{
            CategoryDto catDto = categoryService.findByCategoryId(quiz.get().getCategoryId());
            System.out.println(quiz.get().getCategoryId()+"   i am here");
            quizDto.setCategoryDto(catDto);


        }catch (Exception e){
            quizDto.setCategoryDto(null);
        }
        return quizDto;
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
