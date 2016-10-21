package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by jay on 10/20/16.
 */
// CustomViewHolder
public class CustomViewholder extends RecyclerView.ViewHolder {

    public TextView mList, mTo_do;
    public Button mAdd_button;
    public CheckBox mCheckbox;

    public CustomViewholder(View itemView) {
        super(itemView);

        mList = (TextView) itemView.findViewById(R.id.Lists);
        mTo_do = (TextView) itemView.findViewById(R.id.To_do);

        mAdd_button = (Button) itemView.findViewById(R.id.Add_button);

        mCheckbox = (CheckBox) itemView.findViewById(R.id.Checkbox1);

    }
}
