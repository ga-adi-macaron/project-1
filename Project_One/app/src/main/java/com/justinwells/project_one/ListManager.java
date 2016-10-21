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
    public boolean isDone (int index1, int index2) { return getList(index1).isDone(index2);}

    public String getText (int index1, int index2) {
        return getList(index1).getItem(index2).getToDo();
    }
    public void removeList (int index) {
       if (index > -1 && toDoLists.get(index) != null) {
           toDoLists.remove(index);
       }

    }
    public void addList(ToDoList list) { toDoLists.add(list); }

    public ToDoList getList (int index) { return toDoLists.get(index); }

    public String getTitle (int index) { return toDoLists.get(index).getTitle(); }

    public int getIndex () {
        index = toDoLists.size()-1;
        return index;}

    public int getSize (int index) {return toDoLists.get(index).getSize();}

    public void done (int index1, int index2) {
        getList(index1).getItem(index2).setDone(true);
    }

    public void notDone (int index1, int index2) {
        getList(index1).getItem(index2).setDone(false);
    }

    public void removeItem (int list, int chore) {
        getList(list).removeItem(chore);
    }

}
