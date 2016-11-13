package com.ezequielc.to_dolist;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by student on 11/13/16.
 */

public class DayViewHolder extends RecyclerView.ViewHolder {
    public TextView mDayList;
    public Button mRemoveButton;

    public DayViewHolder(View itemView) {
        super(itemView);

        mDayList = (TextView) itemView.findViewById(R.id.days_of_week);
        mRemoveButton = (Button) itemView.findViewById(R.id.remove_day_button);
    }
}
