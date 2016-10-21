package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jay on 10/20/16.
 */
public class CustomRecyclerView extends RecyclerView.Adapter<CustomViewholder> {
    ArrayList<CustomList> mCustomList;

    public CustomRecyclerView(List<CustomList> customList) {

        mCustomList = (ArrayList<CustomList>) customList;
    }

    @Override
    public CustomViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.customlist_layout, parent, false);
        return new CustomViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomViewholder holder, int position) {
        holder.mList.setText(mCustomList.get(position).customList);

    } //create clickListener below

    @Override
    public int getItemCount() {
        return 0;
    }
}
