package net.serkanbal.project1;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * Created by Serkan on 19/10/16.
 */

public class ListRecyclerAdapter extends RecyclerView.Adapter<ListViewHolder> {
    List<ToDoList> mToDoList;

    public ListRecyclerAdapter(List<ToDoList> toDoList) {
        mToDoList = toDoList;
    }

    @Override
    public ListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.todolist_layout,
                parent, false);
        return new ListViewHolder(itemView);    }

    @Override
    public void onBindViewHolder(ListViewHolder holder, int position) {
        holder.mTextViewList.setText(mToDoList.get(position).getToDoListName());
    }

    @Override
    public int getItemCount() {
        return mToDoList.size();
    }
}
