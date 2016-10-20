package com.scottlindley.muchtodowithoutado.Activities;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDo;
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

        mRecyclerView = (RecyclerView) findViewById(R.id.items_list);
        mListName = (TextView) findViewById(R.id.list_name);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.list_floating_action_button);
        mListData = ToDoListCollection.getInstance();

        setFloatingActionButtonClickListener();

        if (mPositionNumber == -1) {
            /*
            If we didn't receive a position number, then it must have been a newly created list.
            Meaning the list we're working with is at the end of the ArrayList.
             */
            mPositionNumber = mListData.getLists().size() - 1;
            mListName.setText(mListData.getLists().get(mListData.getLists().size() - 1).getName());
        } else {
            //Else, pull the name of the list from the selected index on the home screen
            mListName.setText(mListData.getLists().get(mPositionNumber).getName());
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(ToDoListActivity.this);
        mRecyclerView.setLayoutManager(layoutManager);

        if (mPositionNumber == -1) {
            mRecyclerView.setAdapter(new ListScreenRecyclerViewAdapter(mListData.getLists().size() - 1));
        } else {
            mRecyclerView.setAdapter(new ListScreenRecyclerViewAdapter(mPositionNumber));
        }
    }

    public void setFloatingActionButtonClickListener() {
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                View dialogView = (inflater.inflate(R.layout.add_list_item_dialog, null));
                dialogBuilder.setView(dialogView);
                final EditText itemName = (EditText) dialogView.findViewById(R.id.new_todo);
                itemName.requestFocus();
                final EditText itemDescription = (EditText) dialogView.findViewById(R.id.details);
                final RadioButton lowPriority = (RadioButton) dialogView.findViewById(R.id.low_priority);
                final RadioButton mediumPriority = (RadioButton) dialogView.findViewById(R.id.medium_priority);
                final RadioButton highPriority = (RadioButton) dialogView.findViewById(R.id.high_priority);

                setRadioButtonClickListeners(lowPriority, mediumPriority, highPriority);

                dialogBuilder.setPositiveButton("okay", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });
                final AlertDialog dialog = dialogBuilder.create();
                dialog.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
                dialog.setOnShowListener(new DialogInterface.OnShowListener() {
                    @Override
                    public void onShow(DialogInterface dialogInterface) {
                        dialog.getButton(Dialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {

                                if (itemName.getText().toString().equals("")) {
                                    itemName.setError("Name cannot be blank");
                                } else {
                                    if (itemDescription.getText().toString().equals("")) {
                                        mListData.getLists().get(mPositionNumber).getItems().add(
                                                new ToDo(itemName.getText().toString(), ""));
                                        mRecyclerView.getAdapter().notifyItemChanged(
                                                mListData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    } else {
                                        mListData.getLists().get(mPositionNumber).getItems().add(
                                                new ToDo(itemName.getText().toString(),
                                                        itemDescription.getText().toString())
                                        );
                                        mRecyclerView.getAdapter().notifyItemChanged(
                                                mListData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    }
                                    int priority;
                                    if (lowPriority.isChecked()) {
                                        priority = 0;
                                    } else if (mediumPriority.isChecked()) {
                                        priority = 1;
                                    } else if (highPriority.isChecked()) {
                                        priority = 2;
                                    } else {
                                        priority = 0;
                                    }
                                    ToDo addedToDo = mListData.getLists().get(mPositionNumber).getItems().get(
                                            mListData.getLists().get(mPositionNumber).getItems().size() - 1);
                                    switch (priority) {
                                        case 0:
                                            addedToDo.mPriority = 0;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                        case 1:
                                            addedToDo.mPriority = 1;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                        case 2:
                                            addedToDo.mPriority = 2;
                                            mRecyclerView.getAdapter().notifyItemChanged(mPositionNumber);
                                            break;
                                    }
                                    dialog.dismiss();
                                }
                                    }
                        });
                    }

                });

                dialog.show();
            }
        });
    }

    public void setRadioButtonClickListeners(final RadioButton low, final RadioButton medium, final RadioButton high) {
        low.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(true);
                medium.setChecked(false);
                high.setChecked(false);
            }
        });
        medium.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(true);
                high.setChecked(false);
            }
        });
        high.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                low.setChecked(false);
                medium.setChecked(false);
                high.setChecked(true);
            }
        });
    }


}


