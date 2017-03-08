package com.twu.biblioteca;

import java.util.*;

class MovieLibrary {
    private static List<Movie> allMovies;

    MovieLibrary() {
        allMovies = new ArrayList<Movie>();
        addAllMovies();
    }

    private void addAllMovies() {
        allMovies.add(new Movie("The Matrix", 1999, "Lana Wachowski, Lilly Wachowski", 8.7));
        allMovies.add(new Movie("I, Robot", 2004, "Alex Proyas", 7.4));
        allMovies.add(new Movie("3 Idiots", 2009, "Rajkumar Hirani", 8.4));
        allMovies.add(new Movie("2012", 2009, "Roland Emmerich", 5.8));
        allMovies.add(new Movie("Zootopia", 2016, "Byron Howard, Rich Moore, Jared Bush", 8.1));
        allMovies.add(new Movie("Pirates of the Caribbean: Dead Men Tell No Tales", 2017, "Joachim Rønning, Espen Sandberg"));
    }

    static List<String> listMovies() {
        List<String> availableMoviesInfo = new ArrayList<String>();
        for (Movie movie : allMovies) {
            if (movie.getAvailability()) {
                String rate = (movie.getRating() == 0) ? "Unrated" : ((Double) movie.getRating()).toString();
                String info = "ID: " + movie.getId() + " || Name: " + movie.getName() + " || Year: " +
                        movie.getYear() + " || Director(s): " + movie.getDirector() + " || Rating: " + rate;
                availableMoviesInfo.add(info);
            }
        }
        return availableMoviesInfo;
    }

    static boolean checkoutAMovie(int movieId, int userId) {
        if (movieId < 1 || movieId > allMovies.size()) {
            return false;
        }
        Movie movie = lookUpMovie(movieId);
        if (!movie.getAvailability()) {
            return false;
        }
        movie.setAvailability(false);
        UserAccount user = UserCenter.lookUpUser(userId);
        user.getMoviesIdCheckedOut().add(movieId);
        return true;
    }

    static boolean returnAMovie(int movieId, int userId) {
        if (movieId < 1 || movieId > allMovies.size()) {
            return false;
        }
        Movie movie = lookUpMovie(movieId);
        if (movie.getAvailability()) {
            return false;
        }
        movie.setAvailability(true);
        UserAccount user = UserCenter.lookUpUser(userId);
        user.getMoviesIdCheckedOut().remove(movieId);
        return true;
    }

    static Movie lookUpMovie(int movieId) {
        return allMovies.get(movieId - 1);
    }
}
