package com.ezequielc.to_dolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DayActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mAddButton;
    private RecyclerView mRecyclerView;
    private DayAdapter mDayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);

        mEditText = (EditText) findViewById(R.id.day_edittext);
        mAddButton = (Button) findViewById(R.id.add_day_button);
        mRecyclerView = (RecyclerView) findViewById(R.id.day_recyclerview);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mDayAdapter = new DayAdapter(DayActivity.this);
        mRecyclerView.setAdapter(mDayAdapter);

        mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String dayEntry = mEditText.getText().toString();

                // Shows an error message for blank input
                if (dayEntry.length() == 0) {
                    mEditText.setError("Please fill field!");
                } else {
                    Singleton.getInstance().addDay(new Day(dayEntry));
                    mEditText.setText("");
                    mRecyclerView.getAdapter().notifyDataSetChanged();
                }
            }
        });
    }
}
