package com.example.mvpsimpleexample.Room;

import android.arch.persistence.room.RoomDatabase;

public abstract class DataBaseEmployee extends RoomDatabase {
    public abstract DaoEmployee daoEmployee ();
}
