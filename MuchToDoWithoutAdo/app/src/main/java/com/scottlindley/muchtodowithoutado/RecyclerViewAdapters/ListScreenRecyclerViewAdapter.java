package com.scottlindley.muchtodowithoutado.RecyclerViewAdapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDo;
import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.ViewHolders.ListScreenViewHolder;

import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/19/2016.
 */

public class ListScreenRecyclerViewAdapter extends RecyclerView.Adapter<ListScreenViewHolder>{
    private ArrayList<ToDo> mItems;

    public ListScreenRecyclerViewAdapter(int positionNumber) {
        mItems = (ArrayList)ToDoListCollection.getInstance().getLists().get(positionNumber).getItems();
    }

    @Override
    public ListScreenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        inflater.inflate(R.layout.list_item_layout, null);
        return  new ListScreenViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(final ListScreenViewHolder holder, final int position) {
        holder.getItemName().setText(mItems.get(position).getItemName());
        holder.getItemDescription().setText(mItems.get(position).getItemDescription());
        holder.getCheckBox().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mItems.get(position).mIsChecked) {
                    mItems.get(position).mIsChecked = true;
                    notifyItemChanged(position);
                } else {
                    mItems.get(position).mIsChecked = false;
                    notifyItemChanged(position);
                }
            }
        });
        if(holder.getCheckBox().isChecked()){
            holder.getCheckBox().setChecked(false);
            holder.getItemName().setAlpha(1.0f);
            holder.getItemDescription().setAlpha(1.0f);
        }else if(!holder.getCheckBox().isChecked()){
            holder.getCheckBox().setChecked(true);
            holder.getItemName().setAlpha(0.5f);
            holder.getItemDescription().setAlpha(0.5f);
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
