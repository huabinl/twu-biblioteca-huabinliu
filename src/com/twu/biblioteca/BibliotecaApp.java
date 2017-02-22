package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {

    public static void main(String[] args) {
        new Library();
        Scanner sc = new Scanner(System.in);
        welcomeMessage();
        mainMenu(sc);
    }

    static void welcomeMessage() {
        String welcome = "Hello, welcome to Biblioteca!";
        System.out.println(welcome);
    }

    private static void mainMenu(Scanner sc) {
        int input = mainMenuInfo(sc);
        while(input != 0) {
            switch(input)
            {
                case 1:
                    listBooks();
                    break;
                case 2:
                    checkoutBook(sc);
                    break;
                case 3:
                    returnBook(sc);
                    break;
                default: System.out.println("Select a valid option!");
            }
            input = mainMenuInfo(sc);
        }
    }

    private static int mainMenuInfo(Scanner sc) {
        System.out.println("\nMain Menu: ");
        System.out.println("List Books (press 1)");
        System.out.println("Checkout (press 2)");
        System.out.println("Return (press 3)");
        System.out.println("Quit (press 0)");
        return sc.nextInt();
    }

    private static void listBooks() {
        List<String> availableBooksInfo = Library.listBooks();
        for (String bookInfo : availableBooksInfo) {
            System.out.println(bookInfo);
        }
    }

    private static void checkoutBook(Scanner sc) {
        System.out.print("Please press the ID of the book to be checked out: ");
        int id = sc.nextInt();
        boolean state = Library.checkoutABook(id);
        if (state) {
            System.out.println("Thank you! Enjoy the book.");
        } else {
            System.out.println("That book is not available.");
        }
    }

    private static void returnBook(Scanner sc) {
        System.out.print("Please press the ID of the book to be returned: ");
        int id = sc.nextInt();
        boolean state = Library.returnABook(id);
        if (state) {
            System.out.println("Thank you for returning the book.");
        } else {
            System.out.println("That is not a valid book to return.");
        }
    }
}
