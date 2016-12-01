package com.justinwells.project_one;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.List;

/**
 * Created by justinwells on 10/21/16.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<CustomViewHolder> {

    List<ToDoItem> choreList;
    private int selectedPos = 0;


    public RecyclerViewAdapter(List<ToDoItem> choreList) {
        this.choreList = choreList;
    }

    @Override
    public CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_object,
                parent,false);
        CustomViewHolder viewHolder = new CustomViewHolder(parentView);
        return  viewHolder;
    }

    @Override
    public void onBindViewHolder(final CustomViewHolder holder, final int position) {
        holder.chore.setText(choreList.get(position).getToDo());
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!choreList.get(position).isDone()){
                    holder.x.setTextColor(Color.RED);
                    choreList.get(position).setDone(true);
                }

                else {
                    holder.x.setTextColor(Color.parseColor("#E9E9E9"));
                    choreList.get(position).setDone(false);
                }


            }
        });



    }

    @Override
    public int getItemCount() {
        return choreList.size();
    }
}
