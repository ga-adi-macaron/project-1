package com.elysium.didit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        ArrayList<CustomList> customList = new ArrayList<>();

        customList.add(new CustomList("1"));
        customList.add(new CustomList("2"));
        customList.add(new CustomList("3"));
        customList.add(new CustomList("4"));
        customList.add(new CustomList("5"));
        }

        CustomRecyclerView CustomRecyclerViewholder = new CustomRecyclerView(CustomList);

        mRecyclerView.setAdapter(CustomViewholder);

        }
    }
