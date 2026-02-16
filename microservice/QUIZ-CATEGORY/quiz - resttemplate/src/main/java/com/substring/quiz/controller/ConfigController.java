package com.substring.quiz.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
@RefreshScope
public class ConfigController {

    @Value("${config.value}")
    private String config;


    @GetMapping("/config")
    public ResponseEntity<?> getConfiValue(){
        return new ResponseEntity<>(config, HttpStatus.OK);
    }


}
