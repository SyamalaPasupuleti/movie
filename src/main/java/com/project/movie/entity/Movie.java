package com.project.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

// import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Document
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String movieName;
    // private Long movieId;
    private String movieLanguage;
    private String movieGenre;
}