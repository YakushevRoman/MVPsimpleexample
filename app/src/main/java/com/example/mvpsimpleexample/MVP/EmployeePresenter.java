package com.example.mvpsimpleexample.MVP;

import android.util.Log;

import com.example.mvpsimpleexample.Constants.Constants;
import com.example.mvpsimpleexample.Room.Employee;

import java.util.List;

public class EmployeePresenter implements EmployeePresenterInterface{
    private EmployeeFragment view;
    private final EmployeeModel model;

    EmployeePresenter(EmployeeModel model) {
        this.model = model;
    }

    void employeeAttachView (EmployeeFragment view){
        this.view = view;
    }

    public void viewIsReady (){
        loadUsers();
    }

    private void loadUsers() {
        model.showUsers(new EmployeeModel.ShowUserCallback() {
            @Override
            public void onShowUser(List<Employee> employees) {
               view.showUsers(employees);
            }
        });
    }

    public void add(){
        Employee employee = view.getEmployee();
        model.addUser(employee,new EmployeeModel.AddUserCallback() {
            @Override
            public void onAddUser() {
                loadUsers();
            }
        });
    }

    public void clear (){
        model.clearUsers(new EmployeeModel.ClearUsersCallBack() {
            @Override
            public void onClearUsers(Integer integer) {
                Log.d(Constants.TAG, "onClearUsers: " + integer);
                loadUsers();
            }
        });
    }

    public void employeeDetachView(){
        view = null;
    }
}
