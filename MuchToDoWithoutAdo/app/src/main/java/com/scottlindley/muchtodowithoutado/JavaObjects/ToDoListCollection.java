package com.scottlindley.muchtodowithoutado.JavaObjects;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/18/2016.
 */
public class ToDoListCollection implements Serializable{
    private static ToDoListCollection ourInstance;
    private ArrayList<ToDoList> lists;

    public static ToDoListCollection getInstance() {
        if(ourInstance==null){
            ourInstance = new ToDoListCollection();
        }
        return ourInstance;
    }

    private ToDoListCollection() {
        lists = new ArrayList<>();
    }

    public ArrayList<ToDoList> getLists(){
        return lists;
    }
}
