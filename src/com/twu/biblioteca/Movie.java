package com.twu.biblioteca;

class Movie {
    private static int counter = 0;
    private final int id;
    private String name;
    private int year;
    private String director;
    private double rating;
    private boolean availability;

    Movie(String name, int year, String director) {
        id = ++counter;
        basicInfoSetup(name, year, director);
        rating = 0;
    }

    Movie(String name, int year, String director, double rating) {
        id = ++counter;
        basicInfoSetup(name, year, director);
        this.rating = rating;
    }

    private void basicInfoSetup(String name, int year, String director) {
        this.name = name;
        this.year = year;
        this.director = director;
        availability = true;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    String getDirector() {
        return director;
    }

    double getRating() {
        return rating;
    }

    void setAvailability(boolean bool) {
        availability = bool;
    }

    boolean getAvailability() {
        return availability;
    }
}
