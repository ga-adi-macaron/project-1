package com.ezequielc.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

public class TasksActivity extends AppCompatActivity {
    private EditText mTask, mDescription;
    private Button mAddButton;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        mTask = (EditText) findViewById(R.id.task_edittext);
        mDescription = (EditText) findViewById(R.id.description_edittext);
        mAddButton = (Button) findViewById(R.id.add_task_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.task_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);


    }
}
