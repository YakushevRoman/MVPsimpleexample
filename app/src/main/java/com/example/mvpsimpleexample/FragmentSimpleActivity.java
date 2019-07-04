package com.example.mvpsimpleexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mvpsimpleexample.Room.AppEmployee;

public class FragmentSimpleActivity extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_data, container, false);

        AppEmployee
                .instance
                .getDataBaseEmployee()
                .daoEmployee()
                .getAllEmployee();
        return view;
    }
}
