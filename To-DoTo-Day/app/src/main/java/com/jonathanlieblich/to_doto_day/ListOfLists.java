package com.jonathanlieblich.to_doto_day;

import java.util.List;

/**
 * Created by jonlieblich on 10/20/16.
 */
public class ListOfLists {
    private static ListOfLists listOfLists = null;
    private static List<ToDoList> toDoLists;
    private static String listOfItemsTitle;

    private static ListOfLists ourInstance = new ListOfLists();

    public static ListOfLists getInstance() {
        if(listOfLists == null)
            listOfLists = new ListOfLists();
        return ourInstance;
    }

    public static List<ToDoList> getToDoLists() {
        return toDoLists;
    }

    public static void setToDoList(List<ToDoList> toDoLister) {
        toDoLists = toDoLister;
    }

    public static void setListTtitle(String title) {
        listOfItemsTitle = title;
    }

    public static String getListTitle() {
        return listOfItemsTitle;
    }
}
