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
        new BookLibrary();
        List<String> availableBooksInfo = BookLibrary.listBooks();
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
        new BookLibrary();
        int originSize = BookLibrary.listBooks().size();
        assertTrue(BookLibrary.lookUpBook(3).getAvailability());
        assertTrue(!BookLibrary.checkoutABook(-1, 1));
        assertTrue(!BookLibrary.checkoutABook(8, 1));
        assertTrue(BookLibrary.checkoutABook(3,  1));
        int checkoutSize = BookLibrary.listBooks().size();
        assertEquals(1, originSize - checkoutSize);
        assertTrue(!BookLibrary.lookUpBook(3).getAvailability());
    }

    @Test
    public void testReturnABook() {
        new BookLibrary();
        assertTrue(!BookLibrary.returnABook(0, 1));
        assertTrue(!BookLibrary.returnABook(1024, 1));
        BookLibrary.checkoutABook(3, 1);
        int checkoutSize = BookLibrary.listBooks().size();
        assertTrue(BookLibrary.returnABook(3, 1));
        int returnSize = BookLibrary.listBooks().size();
        assertEquals(1, returnSize - checkoutSize);
        assertTrue(BookLibrary.lookUpBook(3).getAvailability());
    }

    @Test
    public void testListMovies() {
        new MovieLibrary();
        List<String> availableMoviesInfo = MovieLibrary.listMovies();
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
        new MovieLibrary();
        int originSize = MovieLibrary.listMovies().size();
        assertTrue(MovieLibrary.lookUpMovie(6).getAvailability());
        assertTrue(!MovieLibrary.checkoutAMovie(0, 1));
        assertTrue(!MovieLibrary.checkoutAMovie(7, 1));
        assertTrue(MovieLibrary.checkoutAMovie(6, 1));
        int checkoutSize = MovieLibrary.listMovies().size();
        assertEquals(1, originSize - checkoutSize);
        assertTrue(!MovieLibrary.lookUpMovie(6).getAvailability());
    }

    @Test
    public void testReturnAMovie() {
        new MovieLibrary();
        assertTrue(!MovieLibrary.returnAMovie(-11, 1));
        assertTrue(!MovieLibrary.returnAMovie(666, 1));
        MovieLibrary.checkoutAMovie(6, 1);
        int checkoutSize = MovieLibrary.listMovies().size();
        assertTrue(MovieLibrary.returnAMovie(6, 1));
        int returnSize = MovieLibrary.listMovies().size();
        assertEquals(1, returnSize - checkoutSize);
        assertTrue(MovieLibrary.lookUpMovie(6).getAvailability());
    }

    @Test
    public void testLogin() {
        new UserCenter();
        UserAccount user = new UserAccount();
        assertEquals(2, user.login("222-2222", "321"));
        assertEquals(0, user.login("222-2222", "123"));
        assertEquals(0, user.login("222-222", "321"));
    }

    @Test
    public void testGetProfile() {
        new UserCenter();
        String profile = UserCenter.getProfile(1);
        assertTrue(profile.contains("Name:"));
        assertTrue(profile.contains("Email:"));
        assertTrue(profile.contains("Phone:"));
    }

}
