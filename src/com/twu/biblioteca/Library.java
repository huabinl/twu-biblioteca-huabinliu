package com.twu.biblioteca;

import java.util.*;

class Library {
    private static List<Book> allBooks;
    private static List<Movie> allMovies;
    private static Map<Character, List> itemsMap;

    Library() {
        allBooks = new ArrayList<Book>();
        addAllBooks();
        allMovies = new ArrayList<Movie>();
        addAllMovies();
        itemsMap = new HashMap<Character, List>();
        addItemsMap();
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

    private void addAllMovies() {
        allMovies.add(new Movie("The Matrix", 1999, "Lana Wachowski, Lilly Wachowski", 8.7));
        allMovies.add(new Movie("I, Robot", 2004, "Alex Proyas", 7.4));
        allMovies.add(new Movie("3 Idiots", 2009, "Rajkumar Hirani", 8.4));
        allMovies.add(new Movie("2012", 2009, "Roland Emmerich", 5.8));
        allMovies.add(new Movie("Zootopia", 2016, "Byron Howard, Rich Moore, Jared Bush", 8.1));
        allMovies.add(new Movie("Pirates of the Caribbean: Dead Men Tell No Tales", 2017, "Joachim Rønning, Espen Sandberg"));
    }

    private void addItemsMap() {
        itemsMap.put('b', allBooks);
        itemsMap.put('m', allMovies);
    }

    static List<String> listBooks() {
        List<String> availableBooksInfo = new ArrayList<String>();
        for (Book book : allBooks) {
            if (book.getAvailability()) {
                String info = "ID: " + book.getId() + " || Name: " + book.getName()
                        + " || Year: " + book.getYear() + " || Author: " + book.getAuthor() ;
                availableBooksInfo.add(info);
            }
        }
        return availableBooksInfo;
    }

    static List<String> listMovies() {
        List<String> availableMoviesInfo = new ArrayList<String>();
        for (Movie movie : allMovies) {
            if (movie.getAvailability()) {
                String rate = (movie.getRating() == 0) ? "Unrated" : ((Double)movie.getRating()).toString();
                String info = "ID: " + movie.getId() + " || Name: " + movie.getName() + " || Year: " + movie.getYear()
                        + " || Director(s): " + movie.getDirector() + " || Rating: " + rate;
                availableMoviesInfo.add(info);
            }
        }
        return availableMoviesInfo;
    }

    static boolean checkoutABook(int id) {
        if (id < 1 || id > allBooks.size()) {
            return false;
        }
        Book book = allBooks.get(id - 1);
        if (!book.getAvailability()) {
            return false;
        }
        book.setAvailability(false);
        return true;
    }

    static boolean checkoutAMovie(int id) {
        if (id < 1 || id > allMovies.size()) {
            return false;
        }
        Movie movie = allMovies.get(id - 1);
        if (!movie.getAvailability()) {
            return false;
        }
        movie.setAvailability(false);
        return true;
    }

    static boolean returnABook(int id) {
        if (id < 1 || id > allBooks.size()) {
            return false;
        }
        Book book = allBooks.get(id - 1);
        if (book.getAvailability()) {
            return false;
        }
        book.setAvailability(true);
        return true;
    }

    static boolean returnAMovie(int id) {
        if (id < 1 || id > allMovies.size()) {
            return false;
        }
        Movie movie = allMovies.get(id - 1);
        if (movie.getAvailability()) {
            return false;
        }
        movie.setAvailability(true);
        return true;
    }
}

