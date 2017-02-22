package com.twu.biblioteca;

class Book extends Item{
    private static int counter = 0;
    private final int id;
    private String author;

    Book(String name, String author, int year) {
        super(name, year);
        id = ++counter;
        this.author = author;
    }

    int getId() {
        return id;
    }

    String getAuthor() {
        return author;
    }

}
