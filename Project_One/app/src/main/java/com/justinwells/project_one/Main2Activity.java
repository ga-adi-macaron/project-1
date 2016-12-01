package com.justinwells.project_one;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.R.string.ok;
import static java.security.AccessController.getContext;

public class Main2Activity extends AppCompatActivity {

    int workingIndex = MainActivity.workingIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView listTitle = (TextView) findViewById(R.id.title);

        Button addButton = (Button) findViewById(R.id.add_button);
        Button backButton = (Button) findViewById(R.id.back_button);
        Button removeButton = (Button) findViewById(R.id.remove_button);

        final RecyclerView recyclerView= (RecyclerView) findViewById(R.id.recycler_view);
        final ListManager listManager = ListManager.getInstance();

        listTitle.setText(listManager.getTitle(workingIndex));

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final List <ToDoItem> toDoList = listManager.getList(workingIndex).getToDoList();
        recyclerView.setAdapter(new RecyclerViewAdapter(toDoList));





        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("Enter Task");
                final EditText task = new EditText(Main2Activity.this);

                builder.setView(task);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        if (task.getText().toString().trim().equalsIgnoreCase("")){
                            Toast.makeText(Main2Activity.this, "Text field cannot be blank",
                                    Toast.LENGTH_SHORT).show();
                        }
                        else {
                            toDoList.add(new ToDoItem(task.getText().toString()));
                            recyclerView.getAdapter().notifyItemInserted(toDoList.size() - 1);
                        }

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog addTask = builder.create();
                addTask.show();

            }
        });

        removeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("Remove Selected Items?");

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        for (int i=0; i< toDoList.size(); i++) {
                            if (toDoList.get(i).isDone()) {
                                toDoList.remove(i);
                                //listManager.getList(workingIndex).removeItem(i);
                                recyclerView.getAdapter().notifyItemRemoved(i);
                                i--;
                            }
                        }
                        //toDoList.remove(toDoList.size()-1);

                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog removeItem = builder.create();
                removeItem.show();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                setResult(RESULT_OK,intent);
                finish();
            }
        });

    }
}
