package com.example.project1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class users {
    private String id;
    private String pw;
    private String name;
    private String ph;
    private char gender;

}
