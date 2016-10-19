package com.scottlindley.muchtodowithoutado.JavaObjects;

import java.util.List;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class ToDoList {
    private String mName;
    private List<ToDo> items;

    public ToDoList(String name, List<ToDo> items) {
        mName = name;
        this.items = items;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public List<ToDo> getItems() {
        return items;
    }

    public void setItems(List<ToDo> items) {
        this.items = items;
    }
}
