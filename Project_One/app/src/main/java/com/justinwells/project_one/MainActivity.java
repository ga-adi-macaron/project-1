package com.justinwells.project_one;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    public static final int LIST_PAGE = 20;
    List <String> title;
    ArrayAdapter<String> arrayAdapter;
    public static int workingIndex = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = new ArrayList<>();
        listView = (ListView) findViewById(R.id.list_view);
        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,title);
        listView.setAdapter(arrayAdapter);

        final Intent intent = new Intent(MainActivity.this, Main2Activity.class);


        FloatingActionButton addList = (FloatingActionButton) findViewById(R.id.button);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("What do you want to do?");


                builder.setPositiveButton("Remove List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListManager listManager = ListManager.getInstance();
                        listManager.removeList(position);
                        title.remove(position);

                        arrayAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("View List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        workingIndex = position;
                        startActivityForResult(intent, LIST_PAGE);
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
        });

        addList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);

                builder.setTitle("Enter List Name");
                final EditText name = new EditText(MainActivity.this);

                name.setHint("My List");
                builder.setView(name);


                builder.setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ListManager listManager = ListManager.getInstance();

                        String listTitle = name.getText().toString();

                        if (listTitle.equals("") || listTitle == null) {
                            listTitle = "My list";
                        }
                        title.add(listTitle);

                        listManager.addList(new ToDoList(listTitle, listManager.getIndex()));

                        arrayAdapter.notifyDataSetChanged();
                    }
                });

                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });


    }
}
