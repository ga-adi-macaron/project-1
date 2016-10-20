package com.jonathanlieblich.to_doto_day;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView toDoListRecycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toDoListRecycler = (RecyclerView) findViewById(R.id.activity_main);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        toDoListRecycler.setLayoutManager(layoutManager);

        ArrayList<ToDoList> testList = new ArrayList<>();
        testList.add(new ToDoList("Test List Title", new ArrayList<ToDoItem>(), 1));

        toDoListRecycler.setAdapter(new ToDoListAdapter(testList));
    }
}
