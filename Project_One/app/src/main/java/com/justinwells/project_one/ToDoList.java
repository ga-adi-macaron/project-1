package com.justinwells.project_one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 10/20/16.
 */

public class ToDoList {
    List<ToDoItem>toDoList;
    String title;
    int listNum;

    public ToDoList(String title, int listNum) {
        this.title = title;
        this.listNum = listNum;
        toDoList = new ArrayList<>();
    }

    public void add (ToDoItem toDo) {
        toDoList.add(toDo);
    }

    public ToDoItem getItem (int index) {
        return toDoList.get(index);
    }

    public void setTitle (String title) {
        this.title = title;
    }

    public String getTitle () {
        return title;
    }

    public int getSize () {
        return toDoList.size();
    }
}
