package com.elysium.didit;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static com.elysium.didit.R.layout.customlist_layout;
import static com.elysium.didit.R.layout.to_do_items;

/**
 * Created by jay on 10/20/16.
 */
public class CustomRecyclerView extends RecyclerView.Adapter {

    public CustomRecyclerView(List<CustomList> customList) {

        mCustomList = customList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View editText = LayoutInflater.from(parent.getContext()).inflate(R.id.customlist_layout, parent, false);
        return new RecyclerView.ViewHolder(editText);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        holder.mEditText.setText(mCustomList.get(position).getText1);

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
