package com.justinwells.project_one;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

/**
 * Created by justinwells on 10/20/16.
 */

public class CustomViewHolder extends RecyclerView.ViewHolder {

    public TextView chore, x;
    public ImageView check;
    public RelativeLayout item;
    public Button button;
    private int listIndex = MainActivity.workingIndex;

    public CustomViewHolder(View itemView) {
        super(itemView);
        x = (TextView) itemView.findViewById(R.id.x);
       /* if (ListManager.getInstance().isDone(listIndex, 0)) {
            x.setTextColor(Color.RED);
        }*/
        chore = (TextView) itemView.findViewById(R.id.chore_text);
        check = (ImageView) itemView.findViewById(R.id.check);
        item = (RelativeLayout) itemView.findViewById(R.id.relative_layout);
        button =  (Button) itemView.findViewById(R.id.button_check);

    }
}
