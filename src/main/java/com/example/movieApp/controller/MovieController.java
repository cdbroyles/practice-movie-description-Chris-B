package com.example.movieApp.controller;

import com.example.movieApp.model.Movie;
import com.example.movieApp.service.MovieService;
import org.apache.http.HttpException;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/movies")

public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping
    public Movie addMovie(@RequestBody Movie movie) throws IOException, HttpException {
        return movieService.addMovie(movie.getTitle(), movie.getRating());
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }
}
