package com.davescar.project1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by ds on 10/20/16.
 */

public class ChoreAdapter extends RecyclerView.Adapter<ChoreHolder> {

    private List<Chore> mChoreList;

    public ChoreAdapter(List<Chore> choreList) {
        mChoreList = choreList;
    }

    @Override
    public ChoreHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View parentView = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewofchore, parent, false);
        ChoreHolder viewHolder = new ChoreHolder(parentView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ChoreHolder holder, int position) {
        holder.mTitle.setText(mChoreList.get(position).getTitle());
        holder.mDescription.setText(mChoreList.get(position).getDescription());
        holder.mDone.setChecked(mChoreList.get(position).isDone());

    }

    @Override
    public int getItemCount() {
        return mChoreList.size();
    }

}
