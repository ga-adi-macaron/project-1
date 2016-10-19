package com.jonathanlieblich.to_doto_day;

/**
 * Created by jonlieblich on 10/19/16.
 */

public class ToDoItem {
    private String mTitle;
    private boolean mComplete;

    public ToDoItem(String title) {
        mComplete = false;
        mTitle = title;
    }
}
