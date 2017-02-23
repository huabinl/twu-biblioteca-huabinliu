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
        assertTrue(Library.getBook(3).getAvailability());
        assertTrue(!Library.checkoutAItem(-1, "book", 1));
        assertTrue(!Library.checkoutAItem(8, "book", 1));
        assertTrue(Library.checkoutAItem(3, "book", 1));
        int checkoutSize = Library.listItems("book").size();
        assertEquals(1, originSize - checkoutSize);
        assertTrue(!Library.getBook(3).getAvailability());
    }

    @Test
    public void testReturnABook() {
        new Library();
        assertTrue(!Library.returnAItem(0, "book", 1));
        assertTrue(!Library.returnAItem(1024, "book", 1));
        Library.checkoutAItem(3, "book", 1);
        int checkoutSize = Library.listItems("book").size();
        assertTrue(Library.returnAItem(3, "book", 1));
        int returnSize = Library.listItems("book").size();
        assertEquals(1, returnSize - checkoutSize);
        assertTrue(Library.getBook(3).getAvailability());
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
        assertTrue(Library.getMovie(6).getAvailability());
        assertTrue(!Library.checkoutAItem(0, "movie", 1));
        assertTrue(!Library.checkoutAItem(7, "movie", 1));
        assertTrue(Library.checkoutAItem(6, "movie", 1));
        int checkoutSize = Library.listItems("movie").size();
        assertEquals(1, originSize - checkoutSize);
        assertTrue(!Library.getMovie(6).getAvailability());
    }

    @Test
    public void testReturnAMovie() {
        new Library();
        assertTrue(!Library.returnAItem(-11, "movie", 1));
        assertTrue(!Library.returnAItem(666, "movie", 1));
        Library.checkoutAItem(6, "movie", 1);
        int checkoutSize = Library.listItems("movie").size();
        assertTrue(Library.returnAItem(6, "movie", 1));
        int returnSize = Library.listItems("movie").size();
        assertEquals(1, returnSize - checkoutSize);
        assertTrue(Library.getBook(6).getAvailability());
    }

    @Test
    public void testLogin() {
        new Library();
        UserAccount user = new UserAccount();
        assertEquals(2, user.login("222-2222", "321"));
        assertEquals(0, user.login("222-2222", "123"));
        assertEquals(0, user.login("222-222", "321"));
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
