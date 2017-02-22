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
                    listItems("book");
                    break;
                case 2:
                    checkoutItem(sc, "book");
                    break;
                case 3:
                    returnItem(sc, "book");
                    break;
                case 4:
                    listItems("movie");
                    break;
                case 5:
                    checkoutItem(sc, "movie");
                    break;
                case 6:
                    returnItem(sc, "movie");
                    break;
                default: System.out.println("Select a valid option!");
            }
            input = mainMenuInfo(sc);
        }
    }

    private static int mainMenuInfo(Scanner sc) {
        System.out.println("\nMain Menu: ");
        System.out.println("List Books (press 1)");
        System.out.println("Checkout a book (press 2)");
        System.out.println("Return a book (press 3)");
        System.out.println("List Movies (press 4)");
        System.out.println("Checkout a book (press 5)");
        System.out.println("Return a book (press 6)");
        System.out.println("Quit (press 0)");
        return sc.nextInt();
    }

    private static void listItems(String item) {
        List<String> availableItemsInfo = Library.listItems(item);
        for (String itemInfo : availableItemsInfo) {
            System.out.println(itemInfo);
        }
    }

    private static void checkoutItem(Scanner sc, String item) {
        System.out.print("Please press the ID of the " + item + " to be checked out: ");
        int id = sc.nextInt();
        boolean state = Library.checkoutAItem(id, item);
        if (state) {
            System.out.println("Thank you! Enjoy the " + item + ".");
        } else {
            System.out.println("That " + item + " is not available.");
        }
    }

    private static void returnItem(Scanner sc, String item) {
        System.out.print("Please press the ID of the " + item + " to be returned: ");
        int id = sc.nextInt();
        boolean state = Library.returnAItem(id, item);
        if (state) {
            System.out.println("Thank you for returning the " + item + ".");
        } else {
            System.out.println("That is not a valid " + item + " to return.");
        }
    }
}
