package com.scottlindley.muchtodowithoutado.RecyclerViewAdapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoList;
import com.scottlindley.muchtodowithoutado.JavaObjects.ToDoListCollection;
import com.scottlindley.muchtodowithoutado.R;
import com.scottlindley.muchtodowithoutado.ViewHolders.HomeScreenViewHolder;

import java.util.List;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeScreenViewHolder>{
    private List<ToDoList> mHomeList = ToDoListCollection.getInstance().getLists();
    private Context mContext;
    public static final String NEW_LIST_NAME_KEY = "newListName";

    public HomeRecyclerViewAdapter(List<ToDoList> homeList, Context context) {
        mHomeList = homeList;
        mContext = context;
    }

    @Override
    public HomeScreenViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        layoutInflater.inflate(R.layout.home_lists, null);
        return new HomeScreenViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(final HomeScreenViewHolder holder, int position) {
        holder.getTextView().setText(mHomeList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return mHomeList.size();
    }
}
