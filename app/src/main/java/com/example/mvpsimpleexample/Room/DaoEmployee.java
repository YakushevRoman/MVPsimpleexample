package com.example.mvpsimpleexample.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoEmployee {

    @Query("Select * from Employee")
    List<Employee> getAllEmployee ();

    @Query("Select first_name, last_name from Employee")
    List <FirstnameLastName> getFirstNameLastName ();
}
