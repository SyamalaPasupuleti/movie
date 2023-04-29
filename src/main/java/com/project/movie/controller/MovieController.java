package com.project.movie.controller;

import com.project.movie.entity.Movie;
import com.project.movie.repository.MovieRepository;
import com.project.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Service;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;


    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            return ResponseEntity.ok(movie.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Movie> createMovie(@RequestBody Movie movie) {
        Movie createdMovie = movieService.createMovie(movie);
        return ResponseEntity.created(URI.create("/movies/" + createdMovie.toString())).body(createdMovie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable("id") Long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        if (movie.isPresent()) {
            movieService.deleteMovieById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    /*@GetMapping("/search/{title}")
    public List<Movie> getMoviesByTitle(@PathVariable("title") String title) {
        List<Movie> movies = movieRepository.findByTitleContainingIgnoreCase(title);
        if (movies.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return movies;
        }
    }*/


}
