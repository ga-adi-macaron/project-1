package shuvalov.nikita.todoornottodo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class SubListRecyclerAdapter extends RecyclerView.Adapter<SubListHolder> {
    private List<Errands> mErrandsList;
    public SubListRecyclerAdapter(List<Errands> errandsList) {mErrandsList = errandsList;}

    @Override
    public SubListHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sublist_form,null);
        return new SubListHolder(view);
    }

    @Override
    public void onBindViewHolder(SubListHolder holder, int position) {
        TextView noteView = (TextView)holder.itemView.findViewById(R.id.note);
        noteView.setText(mErrandsList.get(position).getText());
    }

    @Override
    public int getItemCount() {
        return mErrandsList.size();
    }
}
