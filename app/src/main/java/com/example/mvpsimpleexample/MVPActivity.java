package com.example.mvpsimpleexample;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.mvpsimpleexample.MVP.EmployeeFragment;

public class MVPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mvp);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.fragment_container_mvp);

        if (fragment == null){
            fragment = new EmployeeFragment();
            fragmentManager
                    .beginTransaction()
                    .add(R.id.fragment_container_mvp, fragment)
                    .commit();
        }
        if (fragment != null){
            fragment = new EmployeeFragment();
            fragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container_mvp, fragment)
                    .commit();
        }
    }
}
