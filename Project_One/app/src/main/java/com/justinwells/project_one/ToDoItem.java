package com.justinwells.project_one;

/**
 * Created by justinwells on 10/20/16.
 */

public class ToDoItem {
    public String toDo;
    boolean isDone;

    public ToDoItem(String toDo) {
        this.toDo = toDo;
        isDone = false;
    }

    public String getToDo() {
        return toDo;
    }

    public void setToDo(String toDo) {
        this.toDo = toDo;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setDone(boolean done) {
        isDone = done;
    }
}
