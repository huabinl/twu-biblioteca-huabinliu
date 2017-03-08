package com.twu.biblioteca;

import java.util.*;

class BookLibrary {
    private static List<Book> allBooks;

    BookLibrary() {
        allBooks = new ArrayList<Book>();
        addAllBooks();
    }

    private void addAllBooks() {
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
            if (book.getAvailability()) {
                String info = "ID: " + book.getId() + " || Name: " + book.getName() +
                        " || Year: " + book.getYear() + " || Author: " + book.getAuthor();
                availableBooksInfo.add(info);
            }
        }
        return availableBooksInfo;
    }

    static boolean checkoutABook(int bookId, int userId) {
        if (bookId < 1 || bookId > allBooks.size()) {
            return false;
        }
        Book book = lookUpBook(bookId);
        if (!book.getAvailability()) {
            return false;
        }
        book.setAvailability(false);
        UserAccount user = UserCenter.lookUpUser(userId);
        user.getBooksIdCheckedOut().add(bookId);
        return true;
    }

    static boolean returnABook(int bookId, int userId) {
        if (bookId < 1 || bookId > allBooks.size()) {
            return false;
        }
        Book book = lookUpBook(bookId);
        if (book.getAvailability()) {
            return false;
        }
        book.setAvailability(true);
        UserAccount user = UserCenter.lookUpUser(userId);
        user.getBooksIdCheckedOut().remove(bookId);
        return true;
    }

    static Book lookUpBook(int id) {
        return allBooks.get(id - 1);
    }
}
