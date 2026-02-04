package com.substring.quiz.serviceimpl;

import com.substring.quiz.dto.CategoryDto;
import com.substring.quiz.service.CategoryService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CategoryServiceImpl implements CategoryService {

    private static final String url="http://localhost:9091/api/v1/";

    public final RestTemplate restTemplate;

    public CategoryServiceImpl(RestTemplate restTemplate){
        this.restTemplate=restTemplate;
    }

    @Override
    public CategoryDto findByCategoryId(String categoryId) {
        String getUrl=url+"category/get/"+categoryId;
        return  restTemplate.getForObject(getUrl, CategoryDto.class);

    }




}
