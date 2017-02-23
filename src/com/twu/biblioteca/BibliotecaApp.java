package com.twu.biblioteca;

import java.util.*;

public class BibliotecaApp {
    private static int userId;
    private static Scanner sc;

    public static void main(String[] args) {
        userId = 0;
        new Library();
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
                    listItems("book");
                    break;
                case 2:
                    checkoutItem("book");
                    break;
                case 3:
                    returnItem("book");
                    break;
                case 4:
                    listItems("movie");
                    break;
                case 5:
                    checkoutItem("movie");
                    break;
                case 6:
                    returnItem("movie");
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
            System.out.print(Library.getProfile(userId));
        }
    }

    private static void listItems(String item) {
        List<String> availableItemsInfo = Library.listItems(item);
        for (String itemInfo : availableItemsInfo) {
            System.out.println(itemInfo);
        }
    }

    private static void checkoutItem(String item) {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the " + item + " to be checked out: ");
            int id = sc.nextInt();
            boolean state = Library.checkoutAItem(id, item, userId);
            if (state) {
                System.out.println("Thank you! Enjoy the " + item + ".");
            } else {
                System.out.println("That " + item + " is not available.");
            }
        }
    }

    private static void returnItem(String item) {
        if (isLogedIn()) {
            System.out.print("Please press the ID of the " + item + " to be returned: ");
            int id = sc.nextInt();
            boolean state = Library.returnAItem(id, item, userId);
            if (state) {
                System.out.println("Thank you for returning the " + item + ".");
            } else {
                System.out.println("That is not a valid " + item + " to return.");
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
