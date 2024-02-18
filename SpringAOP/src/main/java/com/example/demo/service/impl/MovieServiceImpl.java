package com.example.demo.service.impl;

import com.example.demo.aop.MovieAspectAnnotation;
import com.example.demo.entities.Movie;
import com.example.demo.repo.MovieRepo;
import com.example.demo.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    MovieRepo movieRepo;
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @MovieAspectAnnotation
    @Override
    public List<Movie> getAllMovie() {
        return movieRepo.findAll();
    }
}
