package com.twu.biblioteca;

import java.io.*;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class ExampleTest {
    private BibliotecaApp app = new BibliotecaApp();

    @Test
    public void testWelcomeMessage() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        app.welcomeMessage();
        assertEquals("Hello, welcome to Biblioteca!\n", outContent.toString());
    }
}
