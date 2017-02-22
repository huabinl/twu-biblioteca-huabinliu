package com.twu.biblioteca;

class Book {
    private static int counter = 0;
    private final int id;
    private String name;
    private String author;
    private int year;
    private boolean availability;

    Book(String name, String author, int year) {
        id = ++counter;
        this.name = name;
        this.author = author;
        this.year = year;
        availability = true;
    }

    int getId() {
        return id;
    }

    String getName() {
        return name;
    }

    String getAuthor() {
        return author;
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
