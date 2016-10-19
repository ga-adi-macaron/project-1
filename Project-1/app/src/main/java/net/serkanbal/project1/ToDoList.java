package net.serkanbal.project1;

/**
 * Created by Serkan on 19/10/16.
 */

public class ToDoList {

    private String mToDoListName;

    public ToDoList(String toDoListName) {
        mToDoListName = toDoListName;
    }

    public ToDoList() {
        mToDoListName = "Trial";
    }

    public String getToDoListName() {
        return mToDoListName;
    }

    public void setToDoListName(String toDoListName) {
        mToDoListName = toDoListName;
    }
}
