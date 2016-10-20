package net.serkanbal.project1;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Serkan on 19/10/16.
 */

public class ToDoList {

    private String mToDoListName;
    private List<ToDoItem> mToDoItems;

    public ToDoList(String toDoListName) {
        mToDoListName = toDoListName;
        mToDoItems = new ArrayList<>();
    }

    public String getToDoListName() {
        return mToDoListName;
    }

    public void setToDoListName(String toDoListName) {
        mToDoListName = toDoListName;
    }

    public List<ToDoItem> getToDoItems() {
        return mToDoItems;
    }

//    BELOW Methods are not used!
//    public void setToDoItems(List<ToDoItem> toDoItems) {
//        mToDoItems = toDoItems;
//    }
//
//    public void addToDoItem(ToDoItem toDoItem) {
//        mToDoItems.add(toDoItem);
//    }

}