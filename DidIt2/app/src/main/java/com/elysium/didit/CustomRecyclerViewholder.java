package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

/**
 * Created by jay on 10/20/16.
 */
// CustomViewHolder
public class CustomRecyclerViewholder extends RecyclerView.ViewHolder {

    public EditText mList, mTo_do;
    public Button mAdd_button;
    public CheckBox mCheckbox;

    public CustomRecyclerViewholder (View itemView) {
        super(itemView);

        mList = (EditText) itemView.findViewById(R.id.Lists);
        mTo_do = (EditText) itemView.findViewById(R.id.To_do);

        mAdd_button = (Button) itemView.findViewById(R.id.Add_button);

        mCheckbox = (CheckBox) itemView.findViewById(R.id.Checkbox1);

    }
}
