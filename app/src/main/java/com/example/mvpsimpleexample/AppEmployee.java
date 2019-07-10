package com.example.mvpsimpleexample;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.mvpsimpleexample.Room.DataBaseEmployee;

public class AppEmployee extends Application {

    private static AppEmployee instance;

    private DataBaseEmployee dataBaseEmployee;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        dataBaseEmployee = Room
                .databaseBuilder(getApplicationContext(), DataBaseEmployee.class, "my_db")
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
