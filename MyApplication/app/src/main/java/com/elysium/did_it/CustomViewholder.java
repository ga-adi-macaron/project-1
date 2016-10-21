package com.elysium.did_it;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

/**
 * Created by jay on 10/21/16.
 */

public class CustomViewholder extends RecyclerView.ViewHolder {

    public TextView mList, mTo_do;
    public Button mAdd;
    public CheckBox mCheckbox, mCheckbox1;

    public CustomViewholder(View itemView) {
        super(itemView);

        mList = (TextView) itemView.findViewById(R.id.lists);
        mTo_do = (TextView) itemView.findViewById(R.id.To_do);

        mAdd = (Button) itemView.findViewById(R.id.add);

        mCheckbox (CheckBox) itemView.findViewById(R.id.checkbox);
        mCheckbox1 (CheckBox) itemView.findViewById(R.id.Checkbox1);
    }
}
