package com.elysium.did_it;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 10/21/16.
 */

public class CustomRecycler extends RecyclerView.Adapter<CustomViewholder> {
    ArrayList<CustomList> mCustomList;

    public CustomRecycler(ArrayList<CustomList> customList) {

        mCustomList = customList;
    }
    @Override
    public CustomViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.id.customlist);
        return new CustomViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewholder holder, int position) {
        holder.mList.setText(mCustomList.get(position).getText1);
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
