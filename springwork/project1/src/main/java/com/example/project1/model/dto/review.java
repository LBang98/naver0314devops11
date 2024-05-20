package com.example.project1.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class review {

    private int num;
    private int rating;
    private String uploadPhoto;
    private String title;
    private String content;
    private Timestamp writeday;
}
