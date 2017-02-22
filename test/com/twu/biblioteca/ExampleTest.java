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
        List<String> availableBooksInfo = Library.listBooks();
        int originSize = availableBooksInfo.size();
        assertEquals(7, originSize);
        for (String bookInfo : availableBooksInfo) {
            assertTrue(bookInfo.contains("Author:"));
            assertTrue(bookInfo.contains("Year published:"));
        }
    }

    @Test
    public void testCheckoutABook() {
        new Library();
        assertTrue(!Library.checkoutABook(-2));
        assertTrue(!Library.checkoutABook(16));
        assertTrue(Library.checkoutABook(3));
        List<String> newAvailableBooksInfo = Library.listBooks();
        int newSize = newAvailableBooksInfo.size();
        assertEquals(6, newSize);
        boolean noCheckoutBook = true;
        for (String bookInfo : newAvailableBooksInfo) {
            if (bookInfo.contains("ID: 3")) {
                noCheckoutBook = false;
            }
        }
        assertTrue(noCheckoutBook);
    }

    @Test
    public void testReturnABook() {
        new Library();
        assertTrue(!Library.returnABook(-2));
        assertTrue(!Library.returnABook(16));
        Library.checkoutABook(3);
        assertTrue(Library.returnABook(3));
    }
}
