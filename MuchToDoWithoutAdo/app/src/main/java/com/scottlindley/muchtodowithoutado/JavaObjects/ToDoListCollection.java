package com.scottlindley.muchtodowithoutado.JavaObjects;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Scott Lindley on 10/18/2016.
 */
public class ToDoListCollection {
    private static ToDoListCollection ourInstance;
    private List<ToDoList> lists;

    public static ToDoListCollection getInstance() {
        if(ourInstance==null){
            ourInstance = new ToDoListCollection();
        }
        return ourInstance;
    }

    private ToDoListCollection() {
        lists = new ArrayList<>();
    }

    public List<ToDoList> getLists(){
        return lists;
    }
}
