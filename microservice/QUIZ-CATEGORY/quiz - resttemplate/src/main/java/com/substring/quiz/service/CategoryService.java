package com.substring.quiz.service;

import com.substring.quiz.dto.CategoryDto;

public interface CategoryService {

    public CategoryDto findByCategoryId(String categoryId);
}
