package com.example.movieApp.repository;

import com.example.movieApp.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

//Gives automatic CRUD operations for movies with no additional SQL
//Springboot handles database queries behind the scenes
public interface MovieRepository extends JpaRepository<Movie, Long> {
}
