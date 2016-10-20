package com.scottlindley.muchtodowithoutado.RecyclerViewAdapters;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.scottlindley.muchtodowithoutado.Activities.ToDoListActivity;
import com.scottlindley.muchtodowithoutado.JavaObjects.OnSwipeTouchListener;
import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoList;
import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.ViewHolders.HomeScreenViewHolder;

import java.util.ArrayList;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeScreenViewHolder>{
    private ArrayList<ToDoList> mHomeList = ToDoListCollection.getInstance().getLists();
    private Context mContext;
    public static final String POSITION_NUMBER = "positionNumber";

    public HomeRecyclerViewAdapter(Context context) {
        mContext = context;
    }

    @Override
    public HomeScreenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View returnView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.home_lists, parent, false);
        return new HomeScreenViewHolder(returnView);
    }

    @Override
    public void onBindViewHolder(final HomeScreenViewHolder holder, final int position) {
        holder.mHomeListName.setText(mHomeList.get(position).getName());
        holder.mRelativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, ToDoListActivity.class);
                intent.putExtra(POSITION_NUMBER, holder.getAdapterPosition());
                mContext.startActivity(intent);
            }
        });

        holder.mRelativeLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                mHomeList.remove(holder.getAdapterPosition());
                notifyItemRemoved(holder.getAdapterPosition());
                return true;
            }
        });

        holder.mRelativeLayout.setOnTouchListener(new OnSwipeTouchListener(mContext){

        });
    }

    @Override
    public int getItemCount() {
        return mHomeList.size();
    }
}
