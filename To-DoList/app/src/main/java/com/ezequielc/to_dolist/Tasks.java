package com.ezequielc.to_dolist;

/**
 * Created by student on 11/13/16.
 */

public class Tasks {
    String mTasks, mDescription;

    public Tasks(String tasks, String description) {
        mTasks = tasks;
        mDescription = description;
    }

    public String getTasks() {
        return mTasks;
    }

    public String getDescription() {
        return mDescription;
    }
}
