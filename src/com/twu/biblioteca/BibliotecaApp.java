package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private static int userId;
    private static Scanner sc;

    public static void main(String[] args) {
        userId = 0;
        new BookLibrary();
        new MovieLibrary();
        new UserCenter();
        sc = new Scanner(System.in);
        welcomeMessage();
        mainMenu();
    }

    static void welcomeMessage() {
        String welcome = "Hello, welcome to Biblioteca!";
        System.out.println(welcome);
    }

    private static void mainMenu() {
        int input = mainMenuInfo();
        while(input != 0) {
            switch(input)
            {
                case 1:
                    listBooks();
                    break;
                case 2:
                    checkoutBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 4:
                    listMovies();
                    break;
                case 5:
                    checkoutMovie();
                    break;
                case 6:
                    returnMovie();
                    break;
                case 7:
                    loginUser();
                    break;
                case 8:
                    showProfile();
                    break;
                default: System.out.println("Select a valid option!");
            }
            input = mainMenuInfo();
        }
    }

    private static int mainMenuInfo() {
        System.out.println("\nMain Menu: ");
        System.out.println("List Books (press 1)");
        System.out.println("Checkout a Book (press 2)");
        System.out.println("Return a book (press 3)");
        System.out.println("List Movies (press 4)");
        System.out.println("Checkout a Movie (press 5)");
        System.out.println("Return a Movie (press 6)");
        System.out.println("Log In (press 7)");
        System.out.println("Show Profile (press 8)");
        System.out.println("Quit (press 0)");
        return sc.nextInt();
    }

    private static void loginUser() {
        System.out.print("Library Number: ");
        String libNum = getInfo();
        System.out.print("Password: ");
        String password = getInfo();
        UserAccount user = new UserAccount();
        userId = user.login(libNum, password);
        if (userId > 0) {
            System.out.println("Welcome back " + libNum + "!");
        } else {
            System.out.println("Incorrect library number or password.");
        }
    }

    private static String getInfo() {
        String s = sc.nextLine().trim();
        while(s.isEmpty()) {
            s = sc.nextLine().trim();
        }
        return s;
    }

    private static void showProfile() {
        if (isLogedIn()) {
            System.out.print(UserCenter.getProfile(userId));
        }
    }

    private static void listBooks() {
        List<String> availableBooksInfo = BookLibrary.listBooks();
        for (String bookInfo : availableBooksInfo) {
            System.out.println(bookInfo);
        }
    }

    private static void checkoutBook() {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the book to be checked out: ");
            int bookId = sc.nextInt();
            boolean state = BookLibrary.checkoutABook(bookId, userId);
            if (state) {
                System.out.println("Thank you! Enjoy the book.");
            } else {
                System.out.println("That book is not available.");
            }
        }
    }

    private static void returnBook() {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the book to be returned: ");
            int bookId = sc.nextInt();
            boolean state = BookLibrary.returnABook(bookId, userId);
            if (state) {
                System.out.println("Thank you for returning the book.");
            } else {
                System.out.println("That is not a valid book to return.");
            }
        }
    }

    private static void listMovies() {
        List<String> availableMoviesInfo = MovieLibrary.listMovies();
        for (String movieInfo : availableMoviesInfo) {
            System.out.println(movieInfo);
        }
    }

    private static void checkoutMovie() {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the movie to be checked out: ");
            int movieId = sc.nextInt();
            boolean state = MovieLibrary.checkoutAMovie(movieId, userId);
            if (state) {
                System.out.println("Thank you! Enjoy the movie.");
            } else {
                System.out.println("That movie is not available.");
            }
        }
    }

    private static void returnMovie() {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the movie to be returned: ");
            int movieId = sc.nextInt();
            boolean state = MovieLibrary.returnAMovie(movieId, userId);
            if (state) {
                System.out.println("Thank you for returning the movie.");
            } else {
                System.out.println("That is not a valid movie to return.");
            }
        }
    }

    private static boolean isLogedIn() {
        if (userId > 0) {
            return true;
        }
        System.out.println("Please log in first.");
        return false;
    }
}
