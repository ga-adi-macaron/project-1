package com.ezequielc.to_dolist;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * Created by student on 11/13/16.
 */

public class TasksAdapter extends RecyclerView.Adapter<TasksViewHolder> {
    private ArrayList<Tasks> mTasksArrayList;

    public TasksAdapter(ArrayList<Tasks> tasksArrayList) {
        mTasksArrayList = tasksArrayList;
    }

    @Override
    public TasksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TasksViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.tasks_list, parent, false));
    }

    @Override
    public void onBindViewHolder(TasksViewHolder holder, int position) {

        Tasks positionOfTasks = mTasksArrayList.get(position);

        holder.mTasks.setText(mTasksArrayList.get(position).getTasks());
        holder.mDescription.setText(mTasksArrayList.get(position).getDescription());
        //holder.mRemoveButton.setOnClickListener();
    }

    @Override
    public int getItemCount() {
        return mTasksArrayList.size();
    }
}
