package com.scottlindley.muchtodowithoutado.Activities;

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
import android.widget.EditText;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.HomeRecyclerViewAdapter;

import static com.scottlindley.muchtodowithoutado.RecyclerViewAdapters.HomeRecyclerViewAdapter.NEW_LIST_NAME_KEY;

public class HomeActivity extends AppCompatActivity {
    private TextView mWelcomeText;
    private FloatingActionButton mFloatingActionButton;
    private RecyclerView mRecyclerView;
    private ToDoListCollection mHomeLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mHomeLists = ToDoListCollection.getInstance();

        mRecyclerView = (RecyclerView)findViewById(R.id.home_recycler);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.home_floating_action_button);

        LinearLayoutManager layoutManager = new LinearLayoutManager(
                HomeActivity.this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(new HomeRecyclerViewAdapter(mHomeLists.getLists(), HomeActivity.this));

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(view.getContext());
                LayoutInflater inflater = LayoutInflater.from(view.getContext());
                View dialogView = (inflater.inflate(R.layout.add_list_dialog_box, null));
                dialogBuilder.setView(dialogView);
                final EditText newListName = (EditText)dialogView.findViewById(R.id.new_list_name);
                dialogBuilder.setPositiveButton("okay", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(newListName.getText().equals("")){
                            newListName.setError("Please give you list a name!");
                        }else{
                            Intent intent = new Intent(HomeActivity.this, ToDoListActivity.class);
                            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                            intent.putExtra(NEW_LIST_NAME_KEY, newListName.getText().toString());
                            view.getContext().startActivity(intent);
                        }
                    }
                });
                dialogBuilder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = dialogBuilder.create();
                dialog.show();
            }
        });
    }
}
