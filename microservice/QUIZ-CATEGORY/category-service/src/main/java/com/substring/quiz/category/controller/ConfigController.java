package com.substring.quiz.category.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category/config")
@RefreshScope
public class ConfigController {

    @Value("${config.value}")
    private String config;


    @GetMapping
    public ResponseEntity<?> getConfigValue(){
        return new ResponseEntity<>(config, HttpStatus.OK);
    }
}
