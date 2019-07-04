package com.example.mvpsimpleexample.Room;

import android.app.Application;
import android.arch.persistence.room.Room;

public class AppEmployee extends Application {

    public static AppEmployee instance;

    private DataBaseEmployee dataBaseEmployee;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBaseEmployee = Room
                .databaseBuilder(this, DataBaseEmployee.class, "my_db.db")
                .build();
    }

    public static AppEmployee getInstance(){
        return instance;
    }

    public DataBaseEmployee getDataBaseEmployee(){
        return dataBaseEmployee;
    }
}
