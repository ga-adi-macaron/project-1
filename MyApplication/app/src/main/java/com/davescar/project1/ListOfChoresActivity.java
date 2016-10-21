package com.davescar.project1;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class ListOfChoresActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    EditText mAddTitle;
    EditText mAddDescription;
    CheckBox mCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_of_chores);
        int position = getIntent().getIntExtra("positionKey",-1);
        if (position== -1) {
            finish();
        }

        ChoreList choreList1 = ListOfTheLists.getInstance().getmListOfTheLists().get(position);

        ChoreAdapter choreAdapter = new ChoreAdapter(choreList1.getToDoList());

        mRecyclerView = (RecyclerView) findViewById(R.id.RView_ListOfChores);

        mAddTitle = (EditText) findViewById(R.id.title);


        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.setAdapter(choreAdapter);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){

                String grabTitle = mAddTitle.getText().toString();
                String grabDescription = mAddDescription.getText().toString();
                Boolean choreFinished = mCheckBox.isChecked();


            }
        });
    }
}


