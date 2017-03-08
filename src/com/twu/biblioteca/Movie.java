package com.twu.biblioteca;

class Movie {
    private String name;
    private int year;
    private boolean availability;
    private static int counter = 0;
    private final int id;
    private String director;
    private double rating;

    Movie(String name, int year, String director) {
        this.name = name;
        this.year = year;
        availability = true;
        id = ++counter;
        this.director = director;
        rating = 0;
    }

    Movie(String name, int year, String director, double rating) {
        this.name = name;
        this.year = year;
        availability = true;
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

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    void setAvailability(boolean bool) {
        availability = bool;
    }

    boolean getAvailability() {
        return availability;
    }

}
