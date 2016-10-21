package com.jonathanlieblich.to_doto_day;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class CreateToDoListActivity extends AppCompatActivity {
    private EditText mEditTitle, mEditDescription;
    private Button mSave, mClear;
    private RecyclerView mListedLists;
    private List<ToDoItem> mToDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do_list);

        mListedLists = (RecyclerView)findViewById(R.id.item_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mListedLists.getContext());
        mListedLists.setLayoutManager(layoutManager);

        mEditTitle = (EditText)findViewById(R.id.list_name);
        mEditDescription = (EditText)findViewById(R.id.priority);

        mSave = (Button)findViewById(R.id.save_button);
        mClear = (Button)findViewById(R.id.clear_button);

        Intent intent = getIntent();

        mEditTitle.setHint("Item Title");
        mEditTitle.setText(intent.getStringExtra("Item Title"));

        mEditDescription.setHint("Item Description");
        mEditDescription.setText(intent.getStringExtra("Item Description"));

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new item to the list, clear EditTexts
                if(mEditTitle.getText().length() < 1) {
                    mEditTitle.setError("Title Cannot Be Empty");
                } else {
                    mToDoList.get(new ToDoListAdapter(mToDoList));
                }
                mEditTitle.setText("");
                mEditDescription.setText("");
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear EditTexts
                mEditTitle.setText("");
                mEditDescription.setText("");
            }
        });

        mListedLists.setAdapter(new CreateToDoListActivityAdapter(mToDoList));
    }
}
