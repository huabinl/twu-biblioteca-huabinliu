package com.twu.biblioteca;

import java.io.*;
import java.util.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void testWelcomeMessage() {
        new BibliotecaApp();
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        BibliotecaApp.welcomeMessage();
        assertEquals("Hello, welcome to Biblioteca!\n", outContent.toString());
    }

    @Test
    public void testListBooks() {
        new Library();
        List<String> availableBooksInfo = Library.listItems("book");
        int originSize = availableBooksInfo.size();
        assertEquals(7, originSize);
        for (String bookInfo : availableBooksInfo) {
            assertTrue(bookInfo.contains("Name:"));
            assertTrue(bookInfo.contains("Author:"));
            assertTrue(bookInfo.contains("Year:"));
        }
    }

    @Test
    public void testCheckoutABook() {
        new Library();
        int originSize = Library.listItems("book").size();
        assertTrue(!Library.checkoutAItem(-1, "book", 1));
        assertTrue(!Library.checkoutAItem(8, "book", 1));
        assertTrue(Library.checkoutAItem(3, "book", 1));
        List<String> newAvailableBooksInfo = Library.listItems("book");
        int newSize = newAvailableBooksInfo.size();
        assertEquals(1, originSize - newSize);
        boolean noCheckoutBook = true;
        for (String bookInfo : newAvailableBooksInfo) {
            if (bookInfo.contains("ID: 3 ")) {
                noCheckoutBook = false;
            }
        }
        assertTrue(noCheckoutBook);
    }

    @Test
    public void testReturnABook() {
        new Library();

        assertTrue(!Library.returnAItem(0, "book", 1));
        assertTrue(!Library.returnAItem(1024, "book", 1));
        Library.checkoutAItem(3, "book", 1);
        int originSize = Library.listItems("book").size();
        assertTrue(Library.returnAItem(3, "book", 1));
        List<String> newAvailableBooksInfo = Library.listItems("book");
        int newSize = newAvailableBooksInfo.size();
        assertEquals(1, newSize - originSize);
        boolean hasReturnedBook = false;
        for (String bookInfo : newAvailableBooksInfo) {
            if (bookInfo.contains("ID: 3 ")) {
                hasReturnedBook = true;
            }
        }
        assertTrue(hasReturnedBook);
    }

    @Test
    public void testListMovies() {
        new Library();
        List<String> availableMoviesInfo = Library.listItems("movie");
        int originSize = availableMoviesInfo.size();
        assertEquals(6, originSize);
        for (String movieInfo : availableMoviesInfo) {
            assertTrue(movieInfo.contains("Name:"));
            assertTrue(movieInfo.contains("Year:"));
            assertTrue(movieInfo.contains("Director(s):"));
            assertTrue(movieInfo.contains("Rating:"));
        }
    }

    @Test
    public void testCheckoutAMovie() {
        new Library();
        int originSize = Library.listItems("movie").size();
        assertTrue(!Library.checkoutAItem(0, "movie", 1));
        assertTrue(!Library.checkoutAItem(7, "movie", 1));
        assertTrue(Library.checkoutAItem(3, "movie", 1));
        List<String> newAvailableMoviesInfo = Library.listItems("movie");
        int newSize = newAvailableMoviesInfo.size();
        assertEquals(1, originSize - newSize);
        boolean noCheckoutMovie = true;
        for (String movieInfo : newAvailableMoviesInfo) {
            if (movieInfo.contains("ID: 3 ")) {
                noCheckoutMovie = false;
            }
        }
        assertTrue(noCheckoutMovie);
    }

    @Test
    public void testReturnAMovie() {
        new Library();
        assertTrue(!Library.returnAItem(-11, "movie", 1));
        assertTrue(!Library.returnAItem(666, "movie", 1));
        Library.checkoutAItem(3, "movie", 1);
        int originSize = Library.listItems("movie").size();
        assertTrue(Library.returnAItem(3, "movie", 1));
        List<String> newAvailableMoviesInfo = Library.listItems("movie");
        int newSize = newAvailableMoviesInfo.size();
        assertEquals(1, newSize - originSize);
        boolean hasReturnedMovie = false;
        for (String movieInfo : newAvailableMoviesInfo) {
            if (movieInfo.contains("ID: 3 ")) {
                hasReturnedMovie = true;
            }
        }
        assertTrue(hasReturnedMovie);
    }

    @Test
    public void testLogin() {
        new Library();
        UserAccount user = new UserAccount();
        assertEquals(2, user.login("222-2222", "321"));
        assertEquals(0, user.login("222-2222", "123"));
    }

    @Test
    public void testGetProfile() {
        new Library();
        String profile = Library.getProfile(1);
        assertTrue(profile.contains("Name:"));
        assertTrue(profile.contains("Email:"));
        assertTrue(profile.contains("Phone:"));
    }

}
