package com.justinwells.project_one;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Main2Activity extends AppCompatActivity {
    List<String> tempList = null;
    int workingIndex = MainActivity.workingIndex;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView listTitle = (TextView) findViewById(R.id.title);
        Button addButton = (Button) findViewById(R.id.add_button);
        Button backButton = (Button) findViewById(R.id.back_button);
        ListView listView = (ListView) findViewById(R.id.list_view_2);
        final ListManager listManager = ListManager.getInstance();

        listTitle.setText(ListManager.getInstance().getTitle(workingIndex));

        tempList = new ArrayList<>();
        for (int i = 0; i < listManager.getSize(workingIndex); i++) {
            tempList.add(listManager.getText(workingIndex,i));
        }
        final ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1,tempList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
               if (listManager.isDone(workingIndex, position)) {
                   listManager.done(workingIndex, position);
               }

               else {
                   listManager.notDone(workingIndex,position);
               }
            }
        });


        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(Main2Activity.this);
                builder.setTitle("Enter Task");
                final EditText task = new EditText(Main2Activity.this);
                task.setHint("Boring Chore");
                builder.setView(task);

                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        listManager.getList(workingIndex)
                                   .add(new ToDoItem(task.getText().toString()));

                        tempList.add(task.getText().toString());
                        adapter.notifyDataSetChanged();

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
