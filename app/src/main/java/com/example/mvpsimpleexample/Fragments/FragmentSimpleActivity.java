package com.example.mvpsimpleexample.Fragments;
import android.os.AsyncTask;
import android.os.Bundle;
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
import com.example.mvpsimpleexample.R;
import com.example.mvpsimpleexample.Recycler.EmployeeAdapter;
import com.example.mvpsimpleexample.Room.DaoEmployee;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;
import java.util.List;

public class FragmentSimpleActivity extends Fragment {
    public static final String TAG = "FragmentSimpleActivity";

    private EditText rEditTextName;
    private EditText rEditTextLastName;
    private RecyclerView recyclerView;
    private EmployeeAdapter rEmployeeAdapter;
    private  DataBaseEmployee dataBaseEmployee;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBaseEmployee = AppEmployee
                .getInstance()
                .getDataBaseEmployee();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_input_data, container, false);

        recyclerView = view.findViewById(R.id.fragment_input_data__recycler_view);

        rEditTextName = view.findViewById(R.id.fragment_input_data__editText_name);
        rEditTextLastName = view.findViewById(R.id.fragment_input_data__editText_last_name);
        Button rButtonAddPerson = view.findViewById(R.id.fragment_input_data__button_add_person);
        rButtonAddPerson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Employee employee = getEmployee();
                AddUserTask addUserTask = new AddUserTask();
                addUserTask.execute(employee);
            }
        });

        Button rButtonShowPeople = view.findViewById(R.id.fragment_input_data__button_show_people);
        rButtonShowPeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ShowUserTask showUserTask = new ShowUserTask();
                showUserTask.execute();
            }
        });

        Button rButtonDeletePeople = view.findViewById(R.id.fragment_input_data__button_delete_people);
        rButtonDeletePeople.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ClearUserTask clearUserTask = new ClearUserTask();
                clearUserTask.execute();
            }
        });

        return view;
    }

    private Employee getEmployee() {
        Employee employee = new Employee();
        employee.setFirstName(rEditTextName.getText().toString());
        employee.setLastName(rEditTextLastName.getText().toString());
        return employee;
    }

    private class  ClearUserTask extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... voids) {
            DaoEmployee daoEmployee = dataBaseEmployee.daoEmployee();
            int n = daoEmployee.delete();
            Log.d(TAG, String.format("Записей удалено : %s ", n));
            return null;
        }
    }

   private class AddUserTask extends AsyncTask <Employee,Void,Void>{

       @Override
       protected Void doInBackground(Employee... employees) {
           Employee employee = employees[0];
           DaoEmployee daoEmployee = dataBaseEmployee.daoEmployee();
           daoEmployee.insert(employee);
           return null;
       }
   }
   private class ShowUserTask extends AsyncTask <Void,Void,List<Employee>>{

       @Override
       protected List<Employee> doInBackground(Void... voids) {
           DaoEmployee daoEmployee = dataBaseEmployee.daoEmployee();
           List <Employee> rEmployeeList = daoEmployee.getAllEmployee();
           for (Employee employee: rEmployeeList) {
               Log.d(TAG, String.format("onClick: id : %s, name: %s, last name : %s ", employee.get_id(), employee.getFirstName(), employee.getLastName()));
           }
           return rEmployeeList;
       }

       @Override
       protected void onPostExecute(List<Employee> employees) {
           rEmployeeAdapter = new EmployeeAdapter(getContext(), employees);
           recyclerView.setAdapter(rEmployeeAdapter);
           recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
       }
   }
}
