package com.project.movie.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document("movie")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Movie {
    @Id
    private Long movieId;
    private String movieName;
    private String movieLanguage;
    private String movieGenre;
}