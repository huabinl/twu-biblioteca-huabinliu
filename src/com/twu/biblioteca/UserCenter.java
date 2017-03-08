package com.twu.biblioteca;

import java.util.*;

class UserCenter {
    private static List<UserAccount> allUsers;

    UserCenter() {
        allUsers = new ArrayList<UserAccount>();
        addAllUsers();
    }

    private void addAllUsers() {
        allUsers.add(new UserAccount("111-1111", "123", "Ellie", "123@126.com", "13012345678"));
        allUsers.add(new UserAccount("222-2222", "321", "Alex", "321@126.com", "13812345678"));
        allUsers.add(new UserAccount("333-3333", "123456", "John", "456@126.com", "15612345678"));
    }

    static String getProfile(int userId) {
        UserAccount user = lookUpUser(userId);
        String profile = "Name: " + user.getName() + " || Email: " + user.getEmail() + " || Phone: " + user.getPhone() + "\n";
        if (!user.getBooksIdCheckedOut().isEmpty()) {
            profile += "Book checked out: \n";
            for (int bookId : user.getBooksIdCheckedOut()) {
                profile += "    " + BookLibrary.lookUpBook(bookId).getName() + " (ID: " + bookId + ")\n";
            }
        }
        if (!user.getMoviesIdCheckedOut().isEmpty()) {
            profile += "Movie checked out: \n";
            for (int movieId : user.getMoviesIdCheckedOut()) {
                profile += "    " + MovieLibrary.lookUpMovie(movieId).getName() + " (ID: " + movieId + ")\n";
            }
        }
        return profile;
    }

    static UserAccount lookUpUser(int userId) {
        return allUsers.get(userId - 1);
    }

}
