package com.example.mvpsimpleexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpsimpleexample.Room.AppEmployee;
import com.example.mvpsimpleexample.Room.DaoEmployee;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;
import com.example.mvpsimpleexample.Room.FirstnameLastName;

import java.util.List;

public class FragmentSimpleActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_data, container, false);

        DataBaseEmployee dataBaseEmployee =AppEmployee
                .instance
                .getDataBaseEmployee();
        DaoEmployee daoEmployee  = dataBaseEmployee.daoEmployee();

        List <Employee> employees = daoEmployee.getAllEmployee();
        List <FirstnameLastName> firstnameLastNames = daoEmployee.getFirstNameLastName();

        return view;
    }
}
