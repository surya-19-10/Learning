package com.example.demo.service;

import com.example.demo.entities.Movie;

import java.util.List;

public interface MovieService {
    Movie saveMovie(Movie movie);
    List<Movie> getAllMovie();
}
