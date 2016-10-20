package com.scottlindley.muchtodowithoutado.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.ListScreenRecyclerViewAdapter;

import static com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.HomeRecyclerViewAdapter.POSITION_NUMBER;

public class ToDoListActivity extends AppCompatActivity {
    private int mPositionNumber;
    private RecyclerView mRecyclerView;
    private TextView mListName;
    private FloatingActionButton mFloatingActionButton;
    private ToDoListCollection mListData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);

        Intent receivedIntent = getIntent();
        mPositionNumber = receivedIntent.getIntExtra(POSITION_NUMBER, -1);

        setFloatingActionButtonClickListener();

        mRecyclerView = (RecyclerView)findViewById(R.id.items_list);
        mListName = (TextView)findViewById(R.id.list_name);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.list_floating_action_button);
        mListData = ToDoListCollection.getInstance();

        if(mPositionNumber==-1){
            /*
            If we didn't receive a position number, then it must have been a newly created list.
            Meaning the list we're working with is at the end of the ArrayList.
             */
            Log.d("IN TODOLIST ACTIVITY", "onCreate: "+mListData.getLists().size());
            mListName.setText(mListData.getLists().get(mListData.getLists().size()-1).getName());
        }else{
            //Else, pull the name of the list from the selected index on the home screen
            mListName.setText(mListData.getLists().get(mPositionNumber).getName());
        }

            LinearLayoutManager layoutManager = new LinearLayoutManager(ToDoListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        if(mPositionNumber==-1){
            mRecyclerView.setAdapter(new ListScreenRecyclerViewAdapter(mListData.getLists().size()-1));
        }else{
            mRecyclerView.setAdapter(new ListScreenRecyclerViewAdapter(mPositionNumber));
        }
    }

    public void setFloatingActionButtonClickListener(){
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
    }
}
