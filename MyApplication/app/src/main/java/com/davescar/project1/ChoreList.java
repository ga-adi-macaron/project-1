package com.davescar.project1;

import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ds on 10/19/16.
 */

public class ChoreList {

    private ArrayList<Chore> mToDoList;
    private String mNameOfList;


    public ChoreList(String nameOfList) {
        mToDoList = new ArrayList<>();
        mNameOfList = nameOfList;


    }

    public ArrayList<Chore> getToDoList() {
        return mToDoList;
    }

    public String getNameOfList() {
        return mNameOfList;
    }

    public void setNameOfList(String nameOfList) {
        mNameOfList = nameOfList;

    }

    public void makeNewChore(Chore chore) {
        mToDoList.add(chore);

   /* public void makeNewList(ChoreList newChoreList) {
        mToDoList.add(newChoreList);
    }*/
}}
