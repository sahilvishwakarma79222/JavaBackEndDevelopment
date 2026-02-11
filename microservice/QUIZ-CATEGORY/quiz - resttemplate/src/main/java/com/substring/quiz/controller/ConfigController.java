package com.substring.quiz.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quiz")
public class ConfigController {

    @Value("${config.value}")
    private String config;


    @GetMapping("/config")
    public ResponseEntity<?> getConfiValue(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }


}
