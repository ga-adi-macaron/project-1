package com.scottlindley.muchtodowithoutado.ViewHolders;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.scottlindley.muchtodowithoutado.R;

import static android.content.ContentValues.TAG;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class HomeScreenViewHolder extends RecyclerView.ViewHolder{
    public TextView mHomeListName;

    public HomeScreenViewHolder(View itemView) {
        super(itemView);

        mHomeListName = (TextView)itemView.findViewById(R.id.home_list_name);
        Log.d(TAG, "HomeScreenViewHolder: "+mHomeListName);
    }

    public TextView getTextView(){
        return  mHomeListName;
    }
}
