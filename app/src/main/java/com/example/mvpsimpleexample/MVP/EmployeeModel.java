package com.example.mvpsimpleexample.MVP;

import android.annotation.SuppressLint;
import android.os.AsyncTask;

import com.example.mvpsimpleexample.Room.DaoEmployee;
import com.example.mvpsimpleexample.Room.DataBaseEmployee;
import com.example.mvpsimpleexample.Room.Employee;
import java.util.List;

 class EmployeeModel{
    private final DataBaseEmployee dataBaseEmployee;

     EmployeeModel(DataBaseEmployee dataBaseEmployee) {
        this.dataBaseEmployee = dataBaseEmployee;
    }

    interface AddUserCallback{
         void onAddUser();
    }

    interface ShowUserCallback {
        void onShowUser (List<Employee> employees);
    }

    interface ClearUsersCallBack {
         void onClearUsers(Integer integer);
    }

    void clearUsers (ClearUsersCallBack clearUsersCallBack){
         ClearUsers clearUsers = new ClearUsers(clearUsersCallBack);
         clearUsers.execute();
    }

     void showUsers (ShowUserCallback showUserCallback){
        ShowUsers showUsers = new ShowUsers(showUserCallback);
        showUsers.execute();
    }

    void addUser (Employee employee, AddUserCallback addUserCallback){
        AddUser addUser = new AddUser(addUserCallback);
        addUser.execute(employee);
    }

    @SuppressLint("StaticFieldLeak")
    private class ShowUsers extends AsyncTask<Void, Void, List<Employee>>{

        private final ShowUserCallback showUserCallback;

         ShowUsers(ShowUserCallback showUserCallback) {
            this.showUserCallback = showUserCallback;
        }

        @Override
        protected List<Employee> doInBackground(Void... voids) {
            return dataBaseEmployee.daoEmployee().getAllEmployee();
        }

        @Override
        protected void onPostExecute(List<Employee> employees) {
            if (showUserCallback != null){
                showUserCallback.onShowUser(employees);
            }
        }
    }

    private class AddUser extends AsyncTask<Employee, Void, Void>{

         private final AddUserCallback addUserCallback;

         private AddUser(AddUserCallback addUserCallback) {
             this.addUserCallback = addUserCallback;
         }

         @Override
        protected Void doInBackground(Employee... employees) {
            DaoEmployee daoEmployee = dataBaseEmployee.daoEmployee();
            daoEmployee.insert(employees[0]);
            return null;
        }

        @Override
        protected void onPreExecute() {
            if (addUserCallback != null){
                addUserCallback.onAddUser();
            }
        }
    }

    private class ClearUsers extends AsyncTask <Void, Void, Integer >{

         private final ClearUsersCallBack clearUsersCallBack;

        private ClearUsers(ClearUsersCallBack clearUsersCallBack) {
            this.clearUsersCallBack = clearUsersCallBack;
        }

        @Override
        protected Integer doInBackground(Void... voids) {
            DaoEmployee daoEmployee = dataBaseEmployee.daoEmployee();
            Integer count = daoEmployee.delete();
            return count;
        }

        @Override
        protected void onPostExecute(Integer integer) {
            if (clearUsersCallBack != null){
                clearUsersCallBack.onClearUsers(integer);
            }
        }
    }

}
