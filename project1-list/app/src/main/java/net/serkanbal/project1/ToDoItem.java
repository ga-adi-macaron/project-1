package net.serkanbal.project1;

/**
 * Created by Serkan on 19/10/16.
 */

public class ToDoItem {
    private String mItemTitle;
    private String mItemDesc;

    public ToDoItem(String itemTitle, String itemDesc) {
        mItemTitle = itemTitle;
        mItemDesc = itemDesc;
    }

    public String getItemTitle() {
        return mItemTitle;
    }

    public void setItemTitle(String itemTitle) {
        mItemTitle = itemTitle;
    }

    public String getItemDesc() {
        return mItemDesc;
    }

    public void setItemDesc(String itemDesc) {
        mItemDesc = itemDesc;
    }

}