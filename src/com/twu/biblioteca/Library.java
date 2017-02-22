package com.twu.biblioteca;

import java.util.*;

class Library {
    private static List<Item> allBooks;
    private static List<Item> allMovies;
    private static Map<String, List<Item>> itemsMap;

    Library() {
        allBooks = new ArrayList<Item>();
        addAllBooks();
        allMovies = new ArrayList<Item>();
        addAllMovies();
        itemsMap = new HashMap<String, List<Item>>();
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
        itemsMap.put("book", allBooks);
        itemsMap.put("movie", allMovies);
    }

    static List<String> listItems(String itemType) {
        List<String> availableItemsInfo = new ArrayList<String>();
        List<Item> allItems = itemsMap.get(itemType);
        for (Item item : allItems) {
            if (item.getAvailability()) {
                String info =  " || Name: " + item.getName() + " || Year: " + item.getYear();
                if (itemType.equals("book")) {
                    Book book = (Book)item;
                    info = "ID: " + book.getId() + info + " || Author: " + book.getAuthor();
                } else if (itemType.equals("movie")) {
                    Movie movie = (Movie)item;
                    String rate = (movie.getRating() == 0) ? "Unrated" : ((Double)movie.getRating()).toString();
                    info = "ID: " + movie.getId() + info + " || Director(s): "
                            + movie.getDirector() + " || Rating: " + rate;
                }
                availableItemsInfo.add(info);
            }
        }
        return availableItemsInfo;
    }

    static boolean checkoutAItem(int id, String itemType) {
        List<Item> allItems = itemsMap.get(itemType);
        if (id < 1 || id > allItems.size()) {
            return false;
        }
        Item item = allItems.get(id - 1);
        if (!item.getAvailability()) {
            return false;
        }
        item.setAvailability(false);
        return true;
    }

    static boolean returnAItem(int id, String itemType) {
        List<Item> allItems = itemsMap.get(itemType);
        if (id < 1 || id > allItems.size()) {
            return false;
        }
        Item item = allItems.get(id - 1);
        if (item.getAvailability()) {
            return false;
        }
        item.setAvailability(true);
        return true;
    }
}

