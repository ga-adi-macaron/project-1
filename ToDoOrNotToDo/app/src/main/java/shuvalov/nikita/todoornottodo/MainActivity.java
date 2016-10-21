package shuvalov.nikita.todoornottodo;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


//ToDo:Add imageView to title_form with the data being held in ErrandsEncapsulator for the icons.
//ToDo:Add a longclickListener in SubListRecyclerAdapter to allow user to remove listItems. ToDo:Add warning dialog to this as well. Can probably use previous warning alert dialog.
//ToDo:Persist Data with either SharedPreferences or OutputFile.
//ToDo:Give user option to edit SuperList info such as Title or description in warning alert Dialog.


public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button addListButt;
    private LinearLayoutManager linearLayoutManager;
    public static final int RETRIEVE_CONTENT = 2369;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListButt = (Button) findViewById(R.id.addlist);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        MasterLister masterLister = MasterLister.getInstance();
        linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        addListButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                LayoutInflater layoutInflater = MainActivity.this.getLayoutInflater();
                builder.setView(layoutInflater.inflate(R.layout.superlist_dialog, null))
                .setPositiveButton("Add to List", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Dialog d = (Dialog) dialog;
                        EditText titleText = (EditText) d.findViewById(R.id.titleInput);
                        EditText descText = (EditText) d.findViewById(R.id.descriptInput);

                        new ErrandsEncapsulator(titleText.getText().toString(), descText.getText().toString());
                    }
                })
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog alertDialog = builder.create();
                alertDialog.show();

            }


        });

        recyclerView.setAdapter(new MainRecyclerAdapter(masterLister.retriveToDoLists()));
    }

}
