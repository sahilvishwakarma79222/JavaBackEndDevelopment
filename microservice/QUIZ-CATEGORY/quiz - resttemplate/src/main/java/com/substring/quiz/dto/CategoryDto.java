package com.substring.quiz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class CategoryDto {

        private long id;
        private String title;
        private String description;
        private boolean active;


}
