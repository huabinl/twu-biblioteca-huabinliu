package com.twu.biblioteca;

class Movie extends Item{
    private static int counter = 0;
    private final int id;
    private String director;
    private double rating;

    Movie(String name, int year, String director) {
        super(name, year);
        id = ++counter;
        this.director = director;
        rating = 0;
    }

    Movie(String name, int year, String director, double rating) {
        super(name, year);
        id = ++counter;
        this.director = director;
        this.rating = rating;
    }

    int getId() {
        return id;
    }

    String getDirector() {
        return director;
    }

    double getRating() {
        return rating;
    }

}
