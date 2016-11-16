package com.ezequielc.to_dolist;

import java.util.ArrayList;

/**
 * Created by student on 11/13/16.
 */
public class Singleton {
    private static Singleton singleton = null;
    private static ArrayList<Day> days;

    public static Singleton getInstance() {
        if (singleton == null) {
            singleton = new Singleton();
        } return singleton;
    }

    private Singleton() {
        days = new ArrayList<>();
    }

    public ArrayList<Day> getDays() {
        return days;
    }

    public void addDay(Day day){
        days.add(day);
    }

    public void removeDay(Day day){
        days.remove(day);
    }
}
