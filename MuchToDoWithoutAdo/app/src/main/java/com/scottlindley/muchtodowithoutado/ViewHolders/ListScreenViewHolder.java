package com.scottlindley.muchtodowithoutado.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.R;

/**
 * Created by Scott Lindley on 10/19/2016.
 */

public class ListScreenViewHolder extends RecyclerView.ViewHolder{
    private TextView mItemName;
    private TextView mItemDescription;
    private CheckBox mCheckBox;


    public ListScreenViewHolder(View itemView) {
        super(itemView);

        mItemName = (TextView)itemView.findViewById(R.id.list_item_name);
        mItemDescription = (TextView)itemView.findViewById(R.id.list_item_description);
        mCheckBox = (CheckBox)itemView.findViewById(R.id.checkbox);
    }

    public TextView getItemName() {
        return mItemName;
    }

    public TextView getItemDescription() {
        return mItemDescription;
    }

    public CheckBox getCheckBox() {
        return mCheckBox;
    }

}
