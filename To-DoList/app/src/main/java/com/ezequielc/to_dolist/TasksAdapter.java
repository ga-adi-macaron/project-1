package com.ezequielc.to_dolist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by student on 11/13/16.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {
    private ArrayList<Tasks> mTasksArrayList;
    private Context mContext;

    public TasksAdapter(Context context, ArrayList<Tasks> tasks) {
        mContext = context;
        mTasksArrayList = tasks;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TasksViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_list, parent, false));
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {

        final Tasks positionOfTasks = mTasksArrayList.get(position);

        holder.mTasks.setText(mTasksArrayList.get(position).getTasks());
        holder.mDescription.setText(mTasksArrayList.get(position).getDescription());
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mTasksArrayList.remove(positionOfTasks);
                Toast.makeText(mContext, "Task: "+positionOfTasks.getTasks()+" Removed!",
                        Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return mTasksArrayList.size();
    }
}
