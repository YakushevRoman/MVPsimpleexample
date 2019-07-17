package com.example.mvpsimpleexample.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Employee.class}, version = 1, exportSchema = false)
public abstract class DataBaseEmployee extends RoomDatabase {
    public abstract DaoEmployee daoEmployee ();
}
