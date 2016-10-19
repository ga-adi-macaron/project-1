package net.serkanbal.project1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView mRecyclerViewList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize the recycler view.
        mRecyclerViewList = (RecyclerView) findViewById(R.id.recyclertodolist);

        //Create the Layout Manager:
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this,
                LinearLayoutManager.VERTICAL, false);

        //Now that we created; call the layout manager
        mRecyclerViewList.setLayoutManager(linearLayoutManager);

        //This part populates the Recycle List.
        List<ToDoList> toDoList = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            toDoList.add(new ToDoList());
        }

        mRecyclerViewList.setAdapter(new ListRecyclerAdapter(toDoList));
    }
}
