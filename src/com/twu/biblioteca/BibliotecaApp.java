package com.twu.biblioteca;

import java.util.Scanner;

public class BibliotecaApp {

    public static void main(String[] args) {
        Library library = new Library();
        Scanner sc = new Scanner(System.in);
        welcomeMessage();
        mainMenu(library, sc);
    }

    static void welcomeMessage() {
        String welcome = "Hello, welcome to Biblioteca!";
        System.out.println(welcome);
    }

    static void mainMenu(Library lib, Scanner sc) {
        int input = mainMenuInfo(sc);
        while(input != 0) {
            if (input == 1) {
                lib.listBook();

            } else {
                System.out.println("Select a valid option!");
            }
            input = mainMenuInfo(sc);
        }
    }

    static int mainMenuInfo(Scanner sc) {
        System.out.println("Main Menu: ");
        System.out.println("List Book (press 1)");
        System.out.println("Quit (press 0)");
        return sc.nextInt();
    }

}
