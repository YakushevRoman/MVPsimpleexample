package com.example.mvpsimpleexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button rMainActivityButtonSingle;
    private Button rMainActivityButtonMVP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rMainActivityButtonSingle = findViewById(R.id.mainActivity__button_single);
        rMainActivityButtonSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        rMainActivityButtonMVP = findViewById(R.id.mainActivity__button_mvp);
        rMainActivityButtonMVP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
