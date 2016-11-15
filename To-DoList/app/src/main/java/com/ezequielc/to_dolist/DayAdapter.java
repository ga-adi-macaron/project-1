package com.ezequielc.to_dolist;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by student on 11/13/16.
 */

public class DayAdapter extends RecyclerView.Adapter<DayViewHolder> {
    private ArrayList<Day> mDayArrayList;
    private Context mContext;

    public DayAdapter(Context context) {
        mContext = context;
        mDayArrayList = Singleton.getInstance().getDays();
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new DayViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.day_list, parent, false));
    }

    @Override
    public void onBindViewHolder(final DayViewHolder holder, int position) {

        final Day positionOfDay = mDayArrayList.get(position);

        holder.mDayList.setText(mDayArrayList.get(position).getDay());
        holder.mRemoveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Singleton.getInstance().removeDay(positionOfDay);
                Toast.makeText(view.getContext(), positionOfDay.getDay()+" Removed",
                        Toast.LENGTH_SHORT).show();
                notifyDataSetChanged();
            }
        });

        holder.mDayList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), TasksActivity.class);
                intent.putExtra("selectedDay", holder.getAdapterPosition());
                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDayArrayList.size();
    }
}
