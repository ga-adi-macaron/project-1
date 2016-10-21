package com.elysium.didit;

//import static android.R.id.text1;
//import static android.R.id.text2;

/**
 * Created by jay on 10/20/16.
 */

public class CustomList {

    private String listName, description;
    private boolean check;

    public CustomList() {}


    public CustomList (String a, String b, boolean checked) {

        this.listName = a;
        this.description = b;
        this.check = checked;
    }

    public String getListName() {
        return listName;
    }

    public String getdescription() {
        return description;
    }

    public boolean isChecked() {
        return check;
    }

    public void setChecked() {
        this.check = checked;




    }
}
