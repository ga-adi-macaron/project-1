package net.serkanbal.project1;
import java.util.ArrayList;

/**
 * Created by Serkan on 20/10/16.
 */
public class Singleton{
    private static Singleton sing = null;
    private static ArrayList<ToDoList> lists;

    private Singleton(){
        lists = new ArrayList<ToDoList>();
    }

    public static Singleton getInstance(){
        if(sing == null){ //you can use == if to check if it is null.
            sing = new Singleton(); //This will create only one time; because school is only null once. Therefore
            //there is only one School object to work with.
        }
        return sing;
    }

    public void addLists(ToDoList trial){
        lists.add(trial);
    }

    public ArrayList<ToDoList> getLists() {
        return lists;
    }

    public ToDoList getListByIndex(int position) {
        return lists.get(position);
    }

}
