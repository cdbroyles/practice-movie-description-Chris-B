package com.example.movieApp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

//Sets up a Movie Table
@Entity
@Getter
@Setter
public class Movie {
    //Creates an ID (auto generated), title, rating, and description column
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private double rating;

    //Changes default length stored in table
    @Column(length = 1000)
    private String description;

    public Movie() {}

    //Lombok uses this annotation to automatically generate getters and setters
    //This constructor defines the structure of the movie data
    public Movie(String title, double rating, String description) {
        this.title = title;
        this.rating = rating;
        this.description = description;
    }
}
