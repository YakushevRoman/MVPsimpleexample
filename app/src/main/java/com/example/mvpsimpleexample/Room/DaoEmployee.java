package com.example.mvpsimpleexample.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface DaoEmployee {

    @Query("Select * from Employee")
    List<Employee> getAllEmployee ();

    @Insert
    void insert (Employee employee);

    @Query("Delete from Employee")
    int delete ();

    @Query("Select first_name, last_name from Employee")
    List <FirstnameLastName> getFirstNameLastName ();
}
