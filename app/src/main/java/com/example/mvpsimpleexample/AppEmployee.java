package com.example.mvpsimpleexample;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.mvpsimpleexample.Room.DataBaseEmployee;

public class AppEmployee extends Application {

    public static AppEmployee instance;

    private DataBaseEmployee dataBaseEmployee;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBaseEmployee = Room
                .databaseBuilder(getApplicationContext(), DataBaseEmployee.class, "database")
                .allowMainThreadQueries()
                .build();
    }

    public static AppEmployee getInstance(){
        return instance;
    }

    public DataBaseEmployee getDataBaseEmployee(){
        return dataBaseEmployee;
    }
}
