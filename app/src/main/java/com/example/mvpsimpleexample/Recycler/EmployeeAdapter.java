package com.example.mvpsimpleexample.Recycler;

import android.content.Context;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpsimpleexample.Constants.Constants;
import com.example.mvpsimpleexample.R;
import com.example.mvpsimpleexample.Room.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    /**
     *
     */
    private List<Employee> rEmployees = new ArrayList<>();
    /**
     *
     */
    public EmployeeAdapter() {
    }
    /**
     * @param viewGroup
     * @param i
     * @return
     */
    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view_items, viewGroup, false);
        return new EmployeeHolder(view);
    }
    /**
     * @param employeeHolder
     * @param i
     */
    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder employeeHolder, int i) {
        employeeHolder.bind(rEmployees.get(i));
    }
    /**
     * @return
     */
    @Override
    public int getItemCount() {
        return rEmployees.size();
    }
    /**
     *
     */
    public void setData (List <Employee> data){
        rEmployees.clear();
        rEmployees.addAll(data);
        notifyDataSetChanged();
        Log.d(Constants.TAG, "setData: " + data.size());
    }

    /**
     *
     */
    class EmployeeHolder extends RecyclerView.ViewHolder{
        private TextView rTextView;
        /**
         * @param itemView
         */
        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            rTextView = itemView.findViewById(R.id.recycler_view_items__text_view);
        }
        /**
         * @param employee
         */
        public void bind (Employee employee){
            rTextView.setText(String.format("ID: %s, NAME: %s, LAST NAME: %s", employee.get_id(), employee.getFirstName(), employee.getLastName()));
        }
    }

}
