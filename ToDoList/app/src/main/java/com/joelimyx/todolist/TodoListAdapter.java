package com.joelimyx.todolist;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Created by Joe on 10/18/16.
 */

public class TodoListAdapter extends RecyclerView.Adapter<TodoListHolder> {

    HashMap<String,LinkedList<DetailItem>> mToDoLists;
    final Intent myIntent = new Intent();
    final Context mContext;
    final CoordinatorLayout mMain;

    public TodoListAdapter(HashMap<String,LinkedList<DetailItem>> toDoLists, Context context, CoordinatorLayout v) {
        mToDoLists = toDoLists;
        mContext=context;
        myIntent.setClass(context,DetailActivity.class);
        mMain = v;
    }

    @Override
    public TodoListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolists_item,parent,false);
        return new TodoListHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final TodoListHolder holder, final int position) {
        final String name = TodoLists.getInstance().getmNameList().get(position);

        holder.mTextView.setText(name);
        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {

                    //Remove the Detail list if the remove icon is clicked
                    case R.id.removeImage:
                        final LinkedList<DetailItem> temp = TodoLists.getInstance().removeDetailListByPosition(holder.getAdapterPosition());
                        notifyItemRemoved(holder.getAdapterPosition());

                        //Snackbar
                        Snackbar snackbar = Snackbar
                                .make(mMain, name+" is deleted.", Snackbar.LENGTH_LONG)

                                //Restore
                                .setAction("Undo", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        Snackbar undo = Snackbar.make(mMain , name+" is restored", Snackbar.LENGTH_LONG);
                                        TodoLists.getInstance().restoreList(name,temp,position);
                                        notifyItemInserted(holder.getAdapterPosition());
                                        undo.show();
                                    }
                                });

                        snackbar.show();
                        break;

                    //Create new activity containing the related detail list
                    case R.id.item_layout:
                        myIntent.putExtra("detailListName",name);
                        mContext.startActivity(myIntent);
                        break;
                }
            }
        };

        holder.mRelativeLayout.setOnClickListener(onClickListener);
        holder.mRemoveImage.setOnClickListener(onClickListener);
    }

    @Override
    public int getItemCount() {
        return TodoLists.getInstance().getmNameList().size();
    }
}