package com.ezequielc.to_dolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 11/13/16.
 */

public class TasksViewHolder extends RecyclerView.ViewHolder {
    public TextView mTasks, mDescription;
    public Button mRemoveButton;

    public TasksViewHolder(View itemView) {
        super(itemView);

        mTasks = (TextView) itemView.findViewById(R.id.task_title);
        mDescription = (TextView) itemView.findViewById(R.id.description_text);
        mRemoveButton = (Button) itemView.findViewById(R.id.remove_task_button);
    }
}
