package com.example.demo.entities;

import lombok.Data;

import javax.persistence.*;
@Table(name = "movie")
@Entity
@Data
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "director")
    private String director;
}
