package com.scottlindley.muchtodowithoutado.ViewHolders;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.R;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class HomeScreenViewHolder extends RecyclerView.ViewHolder{
    private TextView mTextView;
    private FloatingActionButton mFloatingActionButton;

    public HomeScreenViewHolder(View itemView) {
        super(itemView);

        mFloatingActionButton = (FloatingActionButton)itemView.findViewById(R.id.home_floating_action_button);
        mTextView = (TextView)itemView.findViewById(R.id.home_list_name);
    }

    public TextView getTextView(){
        return  mTextView;
    }

    public FloatingActionButton getFloatingActionButton(){
        return mFloatingActionButton;
    }
}
