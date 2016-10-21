package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by jay on 10/20/16.
 */
// CustomViewHolder
public class CustomViewholder extends RecyclerView.ViewHolder {

    public TextView mList, mTo_do;
    public CheckBox mCheckbox, mCheckbox2;
    public RelativeLayout mMy_Lists;

    public EditText mentry;

    public CustomViewholder(View itemView) {
        super(itemView);

        mList = (TextView) itemView.findViewById(R.id.Lists);
        mTo_do = (TextView) itemView.findViewById(R.id.To_do);

        mMy_Lists = (RelativeLayout) itemView.findViewById(R.id.My_Lists);

        mCheckbox = (CheckBox) itemView.findViewById(R.id.Checkbox);
        mCheckbox2 = (CheckBox) itemView.findViewById(R.id.Checkbox1);

        mentry = (EditText) itemView.findViewById(R.id.entry);

    }
}
