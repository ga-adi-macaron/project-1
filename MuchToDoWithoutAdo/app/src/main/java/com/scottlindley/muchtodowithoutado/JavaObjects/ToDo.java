package com.scottlindley.muchtodowithoutado.JavaObjects;

/**
 * Created by Scott Lindley on 10/18/2016.
 */

public class ToDo {
    private String mItemName;
    private String mItemDescription;
    private int mPriority;
    public static final int HIGH_PRIORITY = 2;
    public static final int MEDIUM_PRIORITY = 1;
    public static final int LOW_PRIORITY = 0;

    public ToDo(String itemName, String itemDescription, int priority) {
        mItemName = itemName;
        mItemDescription = itemDescription;
        mPriority = priority;
    }

    public String getItemName() {
        return mItemName;
    }

    public void setItemName(String itemName) {
        mItemName = itemName;
    }

    public String getItemDescription() {
        return mItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        mItemDescription = itemDescription;
    }

    public int getPriority() {
        return mPriority;
    }

    public void setPriority(int priority) {
        mPriority = priority;
    }
}
