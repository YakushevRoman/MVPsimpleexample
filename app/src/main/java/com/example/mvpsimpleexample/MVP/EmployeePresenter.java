package com.example.mvpsimpleexample.MVP;

public class EmployeePresenter {
    private EmployeeFragment view;
    final EmployeeModel model;

    public EmployeePresenter(EmployeeModel model) {
        this.model = model;
    }
}
