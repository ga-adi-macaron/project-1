package com.joelimyx.todolist;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.LinkedList;

public class DetailActivity extends AppCompatActivity {
    RecyclerView mDetailRecycler;
    FloatingActionButton mDetailFloatingActionBar;
    TextView mListName;
    ImageView mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_list);

        //Toolbar!!!
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final ActionBar ab = getSupportActionBar();

        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowCustomEnabled(true); // enable overriding the default toolbar layout
        ab.setDisplayShowTitleEnabled(false);
        mBackButton = (ImageView) findViewById(R.id.up);

        Intent detailIntent = getIntent();
        String name = detailIntent.getStringExtra("detailListName");
        final LinkedList<DetailItem> detailList = TodoLists.getInstance().getDetailListByName(name);

        //Toolbar Title name
        mListName = (TextView) findViewById(R.id.detail_toolbar);
        mListName.setText(name+" List");

        mDetailRecycler = (RecyclerView) findViewById(R.id.detail_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mDetailRecycler.setLayoutManager(linearLayoutManager);

        final DetailViewAdapter detailViewAdapter = new DetailViewAdapter(detailList,DetailActivity.this);
        mDetailRecycler.setAdapter(detailViewAdapter);

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Add Task
                switch (v.getId()) {
                    case R.id.detail_fab:

                        //Inflate dialog
                        AlertDialog.Builder dialog = new AlertDialog.Builder(DetailActivity.this);
                        View view = getLayoutInflater().inflate(R.layout.detail_dialog, null);

                        //Edit Text Reference
                        final EditText mTitleEdit = (EditText) view.findViewById(R.id.title_edit);
                        final EditText mDetailEdit = (EditText) view.findViewById(R.id.detail_edit);

                        //Create dialog and show
                        dialog.setView(view).setPositiveButton("Add", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                String title = mTitleEdit.getText().toString();
                                String detail = mDetailEdit.getText().toString();
                                //Check if either field is empty
                                if (title.isEmpty()) {
                                    Toast.makeText(DetailActivity.this, "Title can't be blank", Toast.LENGTH_SHORT).show();
                                } else {
                                    detailList.add(new DetailItem(title, detail));
                                    detailViewAdapter.notifyItemInserted(detailList.size() - 1);
                                }
                            }
                        }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        }).create().show();
                        break;

                    //Return to home
                    case R.id.up:
                        finish();
                        break;
                }
            }
        };

        mDetailFloatingActionBar = (FloatingActionButton) findViewById(R.id.detail_fab);
        mDetailFloatingActionBar.setOnClickListener(onClickListener);
    }
}