package com.davescar.project1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by ds on 10/20/16.
 */

public class ListHolder extends RecyclerView.ViewHolder {

    private TextView mTitle;

    public ListHolder(View itemView) {
        super(itemView);

        mTitle = (TextView) itemView.findViewById(R.id.title);
    }

    public TextView getTitle() {
        return mTitle;
    }
}

