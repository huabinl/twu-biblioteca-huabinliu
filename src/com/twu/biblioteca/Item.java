package com.twu.biblioteca;

class Item {
    private String name;
    private int year;
    private boolean availability;

    Item(String name, int year) {
        this.name = name;
        this.year = year;
        availability = true;
    }

    String getName() {
        return name;
    }

    int getYear() {
        return year;
    }

    void setAvailability(boolean bool) {
        availability = bool;
    }

    boolean getAvailability() {
        return availability;
    }
}
