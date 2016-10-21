package shuvalov.nikita.todoornottodo;

/**
 * Created by NikitaShuvalov on 10/20/16.
 */

public class Errands {
    public String mText;
    public boolean mChecked;
    public Errands(String text){mText = text;
    mChecked=false;}

    public String getText() {return mText;}

    public void setText(String text) {mText = text;}

    public void toggleChecked(){
        mChecked = !mChecked;
    }
    public boolean getCheckedStatus(){return mChecked;}

}
