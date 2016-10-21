package com.jonathanlieblich.to_doto_day;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by jonlieblich on 10/20/16.
 */

public class CreateToDoListActivityAdapter extends RecyclerView.Adapter<ToDoItemViewHolder> {
    List<ToDoItem> mToDoItems;

    public CreateToDoListActivityAdapter(List<ToDoItem> toDoList) {
        mToDoItems = ListOfLists.getInstance().getToDoLists();
    }

    @Override
    public ToDoItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View newView = inflater.inflate(R.layout.todo_list_item, parent, false);

        ToDoItemViewHolder viewHolder = new ToDoItemViewHolder(newView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ToDoItemViewHolder holder, int position) {
        ToDoItem toDoItem = ListOfLists.getInstance().getToDoLists().get(position).getToDoItems().get(position);

        holder.mItemName.setText(toDoItem.getTitle());
//        holder.mItemDescription.setText(toDoItem.getDescription());
    }

    @Override
    public int getItemCount() {
        return ListOfLists.getInstance().getToDoLists().size();
    }
}
