package com.jonathanlieblich.to_doto_day;

/**
 * Created by jonlieblich on 10/20/16.
 */
public class ListOfLists {

    private static ListOfLists ourInstance = new ListOfLists();

    public static ListOfLists getInstance() {
        return ourInstance;
    }

    private ListOfLists() {
    }
}
