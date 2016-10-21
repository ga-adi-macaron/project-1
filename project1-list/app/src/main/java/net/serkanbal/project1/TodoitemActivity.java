package net.serkanbal.project1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class TodoitemActivity extends AppCompatActivity {
    BaseAdapter mItemAdapter;
    ListView mItemView;
    List<ToDoItem> mItemList;
    FloatingActionButton mItemFab;
    Singleton mySingleton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todoitem);

        Intent intent = getIntent();
        int position = intent.getIntExtra("POSITION", 0);
        String listName = intent.getStringExtra("LISTNAME");
        setTitle("To-Do List: " + listName);

        mySingleton = Singleton.getInstance();
        mItemList = mySingleton.getListByIndex(position).getToDoItems();

        mItemAdapter = new BaseAdapter() {
            @Override
            public int getCount() {
                return mItemList.size();
            }

            @Override
            public Object getItem(int position) {
                return mItemList.get(position);
            }

            @Override
            public long getItemId(int position) {
                return position;
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null) {
                    LayoutInflater inflater = LayoutInflater.from(TodoitemActivity.this);
                    convertView = inflater.inflate(R.layout.secondaryviewlist_layout, null);
                }

                TextView textView = (TextView) convertView.findViewById(android.R.id.text1);
                textView.setText(mItemList.get(position).getItemTitle());
                TextView textView1 = (TextView) convertView.findViewById(android.R.id.text2);
                textView1.setText(mItemList.get(position).getItemDesc());

                return convertView;
            }
        };

        //Set the adapter
        mItemView = (ListView) findViewById(R.id.list_view_items);
        mItemFab = (FloatingActionButton) findViewById(R.id.fabitems);
        mItemView.setAdapter(mItemAdapter);

        mItemFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutInflater layoutInflater = LayoutInflater.from(TodoitemActivity.this);
                final View promptsView = layoutInflater.inflate(R.layout.dialogitem_layout, null);
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                        TodoitemActivity.this);

                // set prompts.xml to alertdialog builder
                alertDialogBuilder.setView(promptsView);

                // set dialog message
                alertDialogBuilder
                        .setCancelable(false)
                        .setPositiveButton("OK",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        EditText inputTitle = (EditText) promptsView.findViewById(R.id.edititemtitle);
                                        String inputTitleUser = inputTitle.getText().toString();
                                        EditText inputDesc = (EditText) promptsView.findViewById(R.id.edititemdesc);
                                        String inputDescUser = inputDesc.getText().toString();
                                        String result = "";
                                        if (inputDescUser.contains("\n") == true) {
                                            String[] split = inputDescUser.split("\n+");
                                            for (int i = split.length - 1; i >= 0; i--) {
                                                result = (i + 1) + ". " + split[i] + "\n" + result;
                                            }
                                        } else {
                                            result = inputDescUser;
                                        }
                                        if (!inputTitleUser.isEmpty() && !inputDescUser.isEmpty()) {
                                            mItemList.add(new ToDoItem(inputTitleUser, result));
                                            mItemAdapter.notifyDataSetChanged();
                                        } else if (inputTitleUser.isEmpty() && !inputDescUser.isEmpty()) {
                                            Toast.makeText(TodoitemActivity.this,
                                                    "Title can't be empty!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (inputDescUser.isEmpty() && !inputTitleUser.isEmpty()) {
                                            Toast.makeText(TodoitemActivity.this,
                                                    "Description can't be empty!",
                                                    Toast.LENGTH_SHORT).show();
                                        } else if (inputDescUser.isEmpty() && inputTitleUser.isEmpty()) {
                                            Toast.makeText(TodoitemActivity.this,
                                                    "Title & Description can't be empty!"
                                                    , Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                })
                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int id) {
                                        dialog.cancel();
                                    }
                                });

                // create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();

                // show it
                alertDialog.show();
            }
        });

        mItemView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                AlertDialog.Builder builder = new AlertDialog.Builder(TodoitemActivity.this);
                builder.setTitle("Please Confirm")
                        .setMessage("Do you really want to delete: " + mItemList.get(position).getItemTitle()+"?")
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                mItemList.remove(position);
                                mItemAdapter.notifyDataSetChanged();
                            }
                        })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                            }
                        });

                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });

    }
}