package com.example.mvpsimpleexample.MVP;

import android.os.AsyncTask;

import com.example.mvpsimpleexample.AppEmployee;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;

import java.util.List;

public class EmployeeModel{
    private DataBaseEmployee dataBaseEmployee = AppEmployee.instance.getDataBaseEmployee();

    interface ShowUserCallback {
        void onShowUser (List<Employee> employees);
    }

    public void showUsers (ShowUserCallback showUserCallback){

    }

    private class ShowUsers extends AsyncTask<Void, Void, List<Employee>>{

        private final ShowUserCallback showUserCallback;

        public ShowUsers(ShowUserCallback showUserCallback) {
            this.showUserCallback = showUserCallback;
        }

        @Override
        protected List<Employee> doInBackground(Void... voids) {
            return null;
        }
    }
}
