package com.twu.biblioteca;

import java.util.*;

class UserAccount {
    private static int counter = 0;
    private static Map<String, String> loginInfo = new HashMap<String, String>();
    private static Map<String, Integer> libNumId = new Hashtable<String, Integer>();
    private final int id;
    private String name;
    private String email;
    private String phone;
    private Set<Integer> booksIdCheckedOut;
    private Set<Integer> moviesIdCheckedOut;

    UserAccount(String libNum, String password, String name, String email, String phone) {
        id = ++counter;
        loginInfo.put(libNum, password);
        libNumId.put(libNum, id);
        this.name = name;
        this.email = email;
        this.phone = phone;
        booksIdCheckedOut = new HashSet<Integer>();
        moviesIdCheckedOut = new HashSet<Integer>();
    }

    UserAccount() {
        id = 0;
    }

    int login(String libNum, String password) {
        if (loginInfo.get(libNum).equals(password)) {
            return libNumId.get(libNum);
        }
        return id;
    }

    String getName() {
        return name;
    }

    String getEmail() {
        return email;
    }

    String getPhone() {
        return phone;
    }

    Set<Integer> getBooksIdCheckedOut() {
        return booksIdCheckedOut;
    }

    Set<Integer> getMoviesIdCheckedOut() {
        return moviesIdCheckedOut;
    }
}
