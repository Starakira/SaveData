package com.lab.savedata.model;

import java.util.ArrayList;
import java.util.List;

public class DataHolder {
    public final List<User> users = new ArrayList<User>();

    private DataHolder() {}

    public static DataHolder getInstance() {
        if( instance == null ) {
            instance = new DataHolder();
        }
        return instance;
    }

    private static DataHolder instance;
}
