package net.serkanbal.project1;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Serkan on 19/10/16.
 */

public class ListViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextViewList;

    public ListViewHolder(View itemView) {
        super(itemView);
        mTextViewList = (TextView) itemView.findViewById(R.id.todolistext);
    }
}
