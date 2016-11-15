package com.ezequielc.to_dolist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TasksActivity extends AppCompatActivity {
    private EditText mTaskEditText, mDescriptionEditText;
    private Button mAddButton;
    private RecyclerView mRecyclerView;
    private TasksAdapter mTasksAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasks);

        int selectedDay = getIntent().getIntExtra("selectedDay", -1);
        if (selectedDay == -1){
            finish();
        }

        final Day day = Singleton.getInstance().getDays().get(selectedDay);

        mTaskEditText = (EditText) findViewById(R.id.task_edittext);
        mDescriptionEditText = (EditText) findViewById(R.id.description_edittext);
        mAddButton = (Button) findViewById(R.id.add_task_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.task_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mTasksAdapter = new TasksAdapter(TasksActivity.this, day.getTasks());
        mRecyclerView.setAdapter(mTasksAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String taskEntry = mTaskEditText.getText().toString();
                String descriptionEntry = mDescriptionEditText.getText().toString();

                Tasks newTasks = new Tasks(taskEntry, descriptionEntry);
                day.getTasks().add(newTasks);

                mTaskEditText.setText("");
                mDescriptionEditText.setText("");
                mRecyclerView.getAdapter().notifyDataSetChanged();
            }
        });
    }
}
