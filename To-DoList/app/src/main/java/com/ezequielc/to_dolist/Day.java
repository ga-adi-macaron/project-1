package com.ezequielc.to_dolist;

import java.util.ArrayList;

/**
 * Created by student on 11/13/16.
 */

public class Day {
    private String mDay;
    private ArrayList<Tasks> mTasks;

    public Day(String day) {
        mDay = day;
        mTasks = new ArrayList<>();
    }

    public String getDay() {
        return mDay;
    }

    public ArrayList<Tasks> getTasks() {
        return mTasks;
    }
}
