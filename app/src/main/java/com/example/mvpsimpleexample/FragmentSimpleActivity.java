package com.example.mvpsimpleexample;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mvpsimpleexample.Room.DaoEmployee;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;
import java.util.List;

public class FragmentSimpleActivity extends Fragment {
    public static final String TAG = "FragmentSimpleActivity";

    private EditText rEditTextName;
    private EditText rEditTextLastName;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_data, container, false);

        DataBaseEmployee dataBaseEmployee =AppEmployee
                .getInstance()
                .getDataBaseEmployee();
        final DaoEmployee daoEmployee  = dataBaseEmployee
                .daoEmployee();

        rEditTextName = view.findViewById(R.id.fragment__editText_name);
        rEditTextLastName = view.findViewById(R.id.fragment__editText_last_name);
        Button rButtonAddPerson = view.findViewById(R.id.fragment__button_add_person);
        rButtonAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = new Employee();
                employee.setFirstName(rEditTextName.getText().toString());
                employee.setLastName(rEditTextLastName.getText().toString());
                daoEmployee.insert(employee);
            }
        });

        Button rButtonShowPeople = view.findViewById(R.id.fragment__button_show_people);
        rButtonShowPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                List<Employee> employees = daoEmployee.getAllEmployee();
                for (Employee employee: employees) {
                    Log.d(TAG, String.format("onClick: id : %s, name: %s, last name : %s ", employee.get_id(), employee.getFirstName(), employee.getLastName()));
                }
            }
        });

        return view;
    }
}
