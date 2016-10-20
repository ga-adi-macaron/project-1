package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import static com.elysium.didit.R.layout.customlist_layout;
import static com.elysium.didit.R.layout.to_do_items;

/**
 * Created by jay on 10/20/16.
 */
public class CustomRecyclerView extends RecyclerView.Adapter<CustomRecyclerViewholder> {
    ArrayList<CustomList> objects;

    public CustomRecyclerView(List<CustomList> customList) {

        this.objects = (ArrayList<CustomList>) customList;
    }

    @Override
    public CustomRecyclerViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.id.customlist_layout, parent, false);
        return new CustomRecyclerViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(CustomRecyclerViewholder holder, int position) {
        holder.mList.setText(objects.get(position).getText1);

    } //create clickListener below

    @Override
    public int getItemCount() {
        return 0;
    }
}
