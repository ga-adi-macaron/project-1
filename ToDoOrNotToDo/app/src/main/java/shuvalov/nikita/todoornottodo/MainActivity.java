package shuvalov.nikita.todoornottodo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private Button addListButt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addListButt = (Button) findViewById(R.id.addlist);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        MasterLister masterLister = MasterLister.getInstance();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);

        addListButt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(MainActivity.this, "This is gonna open a dialog", Toast.LENGTH_SHORT).show();
            }
        });

        for (int i = 0; i < 20; i++) {
            masterLister.appendToDoList(new ErrandsEncapsulator("This is only a test", "This is a test of the emergency response system."));
        }
        recyclerView.setAdapter(new MainRecyclerAdapter(masterLister.retriveToDoLists()));
    }
}
