package com.elysium.didit;

import android.content.Intent;
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
    public void onBindViewHolder(final CustomViewholder holder, final int position) {
        holder.mList.setText(mCustomList.get(position).getListName());

        holder.mMy_Lists.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent movePage = new Intent(v.getContext(), SecondActivity.class);
                movePage.putExtra("List Name", position);
                v.getContext().startActivity(movePage);
                notifyDataSetChanged();

                // create intent to send to next activity
                // pass along position (int)

            }
        });

    }

    @Override
    public int getItemCount() {
        return mCustomList.size();
    }
}
