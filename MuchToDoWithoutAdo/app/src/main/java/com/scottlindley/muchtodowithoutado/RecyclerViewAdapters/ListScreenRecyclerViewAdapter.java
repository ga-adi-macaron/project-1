package com.scottlindley.muchtodowithoutado.RecyclerViewAdapters;

import android.graphics.Color;
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
        View returnView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.list_item_layout, parent, false);
        return  new ListScreenViewHolder(returnView);
    }

    @Override
    public void onBindViewHolder(final ListScreenViewHolder holder, final int position) {
        holder.mItemName.setText(mItems.get(holder.getAdapterPosition()).mItemName);
        holder.mItemDescription.setText(mItems.get(holder.getAdapterPosition()).mItemDescription);
        holder.mCheckBox.setChecked(mItems.get(holder.getAdapterPosition()).mIsChecked);
        holder.mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mItems.get(holder.getAdapterPosition()).mIsChecked) {
                    mItems.get(holder.getAdapterPosition()).mIsChecked = true;
                    notifyItemChanged(holder.getAdapterPosition());
                } else {
                    mItems.get(holder.getAdapterPosition()).mIsChecked = false;
                    notifyItemChanged(holder.getAdapterPosition());
                }
            }
        });

        holder.mRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mItems.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                return true;
            }
        });


        if(!holder.mCheckBox.isChecked()){
            holder.mCheckBox.setChecked(false);
            holder.mItemName.setAlpha(1.0f);
            holder.mItemDescription.setAlpha(1.0f);
        }else if(holder.mCheckBox.isChecked()){
            holder.mCheckBox.setChecked(true);
            holder.mItemName.setAlpha(0.4f);
            holder.mItemDescription.setAlpha(0.4f);
        }

        switch (mItems.get(position).mPriority){
            case 0:
                holder.mItemName.setTextColor(Color.rgb(69,69,69));
                break;
            case 1:
                holder.mItemName.setTextColor(Color.rgb(214,153,2));
                break;
            case 2:
                holder.mItemName.setTextColor(Color.rgb(195,0,0));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }
}
