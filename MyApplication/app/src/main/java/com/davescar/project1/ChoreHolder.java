package com.davescar.project1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by ds on 10/20/16.
 */

public class ChoreHolder extends RecyclerView.ViewHolder {

    public TextView mTitle;
    public TextView mDescription;
    public CheckBox mDone;

    public ChoreHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.title);
        mDescription = (TextView) itemView.findViewById(R.id.description);
        mDone = (CheckBox) itemView.findViewById(R.id.done);


    }
}