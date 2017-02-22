package com.twu.biblioteca;

import java.util.*;

class Library {
    private static List<Book> allBooks;

    Library() {
        allBooks = new ArrayList<Book>();

        allBooks.add(new Book("Harry Potter and the Philosopher's Stone", "J. K. Rowling", 1997));
        allBooks.add(new Book("Harry Potter and the Chamber of Secrets", "J. K. Rowling", 1998));
        allBooks.add(new Book("Harry Potter and the Prisoner of Azkaban", "J. K. Rowling", 1999));
        allBooks.add(new Book("Harry Potter and the Goblet of Fire", "J. K. Rowling", 2000));
        allBooks.add(new Book("Harry Potter and the Order of the Phoenix", "J. K. Rowling", 2003));
        allBooks.add(new Book("Harry Potter and the Half-Blood Prince", "J. K. Rowling", 2005));
        allBooks.add(new Book("Harry Potter and the Deathly Hallows", "J. K. Rowling", 2007));
    }

    static List<String> listBooks() {
        List<String> availableBooksInfo = new ArrayList<String>();
        for (Book book : allBooks) {
            if (book.getAvailable()) {
                String info = "ID: " + book.getId() + " || Title: " + book.getTitle()
                        + " || Author: " + book.getAuthor() + " || Year published: " + book.getYearPublished();
                availableBooksInfo.add(info);
            }
        }
        return availableBooksInfo;
    }

    static boolean checkoutABook(int id) {
        if (id < 1 || id > allBooks.size()) {
            return false;
        }
        Book book = allBooks.get(id - 1);
        if (!book.getAvailable()) {
            return false;
        }
        book.setAvailable(false);
        return true;
    }

    static boolean returnABook(int id) {
        if (id < 1 || id > allBooks.size()) {
            return false;
        }
        Book book = allBooks.get(id - 1);
        if (book.getAvailable()) {
            return false;
        }
        book.setAvailable(true);
        return true;
    }

}

