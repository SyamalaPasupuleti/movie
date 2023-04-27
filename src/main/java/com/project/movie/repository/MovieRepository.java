package com.project.movie.repository;

import com.project.movie.entity.Movie;
// import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface MovieRepository extends MongoRepository<Movie, Long> {

}
