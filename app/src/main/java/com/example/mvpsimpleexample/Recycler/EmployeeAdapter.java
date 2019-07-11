package com.example.mvpsimpleexample.Recycler;

import android.content.Context;
import android.print.PrinterId;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.mvpsimpleexample.R;
import com.example.mvpsimpleexample.Room.Employee;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeHolder> {
    private LayoutInflater rLayoutInflater;
    private List<Employee> rEmployees;

    public EmployeeAdapter(Context context, List<Employee> rEmployees) {
        this.rEmployees = rEmployees;
        rLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public EmployeeHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = rLayoutInflater.inflate(R.layout.recycler_view_items, viewGroup, false);
        return new EmployeeHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeHolder employeeHolder, int i) {
        employeeHolder.bind(rEmployees.get(i));
    }

    @Override
    public int getItemCount() {
        return rEmployees.size();
    }

    class EmployeeHolder extends RecyclerView.ViewHolder{
        private TextView rTextView;

        public EmployeeHolder(@NonNull View itemView) {
            super(itemView);
            rTextView = itemView.findViewById(R.id.recycler_view_items__text_view);
        }
        public void bind (Employee employee){
            rTextView.setText(String.format("ID: %s, NAME: %s, LAST NAME: %s", employee.get_id(), employee.getFirstName(), employee.getLastName()));
        }
    }

}
