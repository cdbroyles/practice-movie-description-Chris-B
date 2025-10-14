package com.example.movieApp.service;

//model + repository
import com.example.movieApp.model.Movie;
import com.example.movieApp.repository.MovieRepository;

//Google Gemini client imports
import com.google.genai.Client;
import com.google.genai.types.GenerateContentResponse;

import org.apache.http.HttpException;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class MovieService {
    //the repository used to save/load Movie entities
    private final MovieRepository movieRepository;
    //Gemini client used to call the API
    private final Client client;

    //Constructor
    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
        //Automatically reads GOOGLE_API_KEY
        this.client = new Client();
    }

    //public method used by controller to add a movie
    //Inputs title and rating
    //uses Gemini to output a description
    //Finally saves movie and returns it
    public Movie addMovie(String title, double rating) throws IOException, HttpException {
        String description;
        description = generateDescription(title);
        //creates a Movie object from the inputs + description
        Movie movie = new Movie(title, rating, description);
        //save to DB
        return movieRepository.save(movie);
    }

    //Uses Gemini to generate a description for a title
    private String generateDescription(String title) throws IOException, HttpException {
        String prompt = "Write a short movie description for the film titled " + title + ".";
        GenerateContentResponse response = client.models.generateContent("gemini-2.0-flash-001", prompt, null);
        //This returns the text from the response
        return response.text();
    }

    //Returns all saved movies.  Used by controller's Get /movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }
}