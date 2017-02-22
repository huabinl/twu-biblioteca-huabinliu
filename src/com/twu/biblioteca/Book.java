package com.twu.biblioteca;

class Book {
    private static int counter = 0;
    private final int id;
    private String title;
    private String author;
    private int yearPublished;

    Book(String title, String author, int yearPublished) {
        id = ++counter;
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    int getId() {
        return id;
    }

    String getTitle() {
        return title;
    }

    String getAuthor() {
        return author;
    }

    int getYearPublished() {
        return yearPublished;
    }

}
