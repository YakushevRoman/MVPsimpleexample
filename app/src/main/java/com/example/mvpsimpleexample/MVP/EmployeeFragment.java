package com.example.mvpsimpleexample.MVP;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvpsimpleexample.AppEmployee;
import com.example.mvpsimpleexample.Constants.Constants;
import com.example.mvpsimpleexample.R;
import com.example.mvpsimpleexample.Recycler.EmployeeAdapter;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;

import java.util.List;

public class EmployeeFragment extends Fragment {
    private EditText rEditTextName;
    private EditText rEditTextLastName;
    private EmployeeAdapter rEmployeeAdapter;

    private EmployeePresenter employeePresenter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBaseEmployee dataBaseEmployee = AppEmployee
                .getInstance()
                .getDataBaseEmployee();
        EmployeeModel employeeModel = new EmployeeModel(dataBaseEmployee);
        employeePresenter = new EmployeePresenter(employeeModel);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_data, container, false);

        rEditTextName = view.findViewById(R.id.fragment_input_data__editText_name);
        rEditTextLastName = view.findViewById(R.id.fragment_input_data__editText_last_name);

        Button rButtonShowPeople = view.findViewById(R.id.fragment_input_data__button_show_people);
        rButtonShowPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button rButtonDeletePeople = view.findViewById(R.id.fragment_input_data__button_delete_people);
        rButtonDeletePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeePresenter.clear();
            }
        });

        Button rButtonAddPerson = view.findViewById(R.id.fragment_input_data__button_add_person);
        rButtonAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                employeePresenter.add();
            }
        });

        rEmployeeAdapter = new EmployeeAdapter();
        RecyclerView recyclerView = view.findViewById(R.id.fragment_input_data__recycler_view);
        recyclerView.setAdapter(rEmployeeAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        employeePresenter.employeeAttachView(this);
        employeePresenter.viewIsReady();
        return view;
    }

    public void showUsers (List <Employee> employees){
        rEmployeeAdapter.setData(employees);
    }

    public Employee getEmployee(){
        Employee employee = new Employee();
        employee.setLastName(rEditTextName.getText().toString());
        employee.setFirstName(rEditTextLastName.getText().toString());
        Log.d(Constants.TAG, "getEmployee: ");
        return employee;
    }
}
