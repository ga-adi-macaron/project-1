package com.elysium.didit;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jay on 10/21/16.
 */

public class RecyclerView2 extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.to_do_items, parent, false);
        return new CustomViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addItem = new Intent(v.getContext(), SecondActivity.class);
                addItem.putExtra("text entry", true);
                v.getContext().startActivity(addItem);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return getItemCount();
    }
}
