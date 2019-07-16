package com.example.mvpsimpleexample.MVP;

import com.example.mvpsimpleexample.Room.Employee;

import java.util.List;

public class EmployeePresenter {
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

    private void addUsers (){

    }

    public void employeeDetachView(){
        view = null;
    }
}
