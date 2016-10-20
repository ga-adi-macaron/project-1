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
    private EditText mEditTitle, mEditPriority;
    private Button mSave, mClear;
    private RecyclerView mListItems;
    private ToDoList mToDoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_to_do_list);

//        mToDoList = ListOfLists.getInstance().getToDoList(position);

        mListItems = (RecyclerView)findViewById(R.id.item_list);

        LinearLayoutManager layoutManager = new LinearLayoutManager(mListItems.getContext());
        mListItems.setLayoutManager(layoutManager);

        mEditTitle = (EditText)findViewById(R.id.list_name);
        mEditPriority = (EditText)findViewById(R.id.priority);

        mSave = (Button)findViewById(R.id.save_button);
        mClear = (Button)findViewById(R.id.clear_button);

        Intent intent = getIntent();

        mEditTitle.setHint("List Title");
        mEditTitle.setText(intent.getStringExtra("List Title"));

        mEditPriority.setHint("List Priority");
        mEditPriority.setText(intent.getStringExtra("List Priority"));

        mSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Add new item to the list, clear EditTexts
                if(mEditTitle.getText().length() < 1) {
                    mEditTitle.setError("Title Cannot Be Empty");
                } else {
                    mToDoList.addNewItem(mEditTitle.getText().toString(), "hi");
                }
                mEditTitle.setText("");
//                mEditPriority.setText("");
            }
        });

        mClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Clear EditTexts
                mEditTitle.setText("");
//                mEditPriority.setText("");
            }
        });

        List<ToDoItem> testList = new ArrayList<>();

        testList.add(new ToDoItem("title1", "description1"));
        testList.add(new ToDoItem("title2", "description2"));
        mToDoList = new ToDoList("TITLE", testList, 5);

        mListItems.setAdapter(new CreateToDoListActivityAdapter(mToDoList));
    }
}
