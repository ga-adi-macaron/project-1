package net.serkanbal.project1;

/**
 * Created by Serkan on 20/10/16.
 */
public class CustomSingleton {
    private static CustomSingleton ourInstance = new CustomSingleton();

    public static CustomSingleton getInstance() {
        return ourInstance;
    }

    private CustomSingleton() {
    }
}
