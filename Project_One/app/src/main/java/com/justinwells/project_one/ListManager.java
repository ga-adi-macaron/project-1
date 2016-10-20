package com.justinwells.project_one;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by justinwells on 10/20/16.
 */

public class ListManager {
    private static List<ToDoList>toDoLists;
    private static ListManager listManager;
    private static int index;

    private ListManager() {
        toDoLists = new ArrayList<>();
        index = 0;
    }

    public static ListManager getInstance () {
        if (listManager == null) {
            listManager = new ListManager();
        }

        return listManager;
    }
    public boolean isDone (int index1, int index2) {
        return getList(index1).getItem(index2).isDone();
    }

    public String getText (int index1, int index2) {
        return getList(index1).getItem(index2).getToDo();
    }

    public void addList(ToDoList list) { toDoLists.add(list); }

    public ToDoList getList (int index) { return toDoLists.get(index); }

    public String getTitle (int index) { return toDoLists.get(index).getTitle(); }

    public int getIndex () {return index;}

    public int getSize (int index) {return toDoLists.get(index).getSize();}

    public void done (int index1, int index2) {
        getList(index1).getItem(index2).setDone(true);
    }

    public void notDone (int index1, int index2) {
        getList(index1).getItem(index2).setDone(false);
    }
}
