package com.twu.biblioteca;

class Book {
    private String name;
    private int year;
    private boolean availability;
    private static int counter = 0;
    private final int id;
    private String author;

    Book(String name, String author, int year) {
        this.name = name;
        this.year = year;
        availability = true;
        id = ++counter;
        this.author = author;
    }

    int getId() {
        return id;
    }

    String getAuthor() {
        return author;
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
