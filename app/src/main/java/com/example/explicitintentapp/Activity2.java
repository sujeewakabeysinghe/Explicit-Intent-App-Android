package com.example.explicitintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tv1;
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        tv1=findViewById(R.id.tv1);
        btn1=findViewById(R.id.btn1);

        String ttname=getIntent().getStringExtra("thisname");
        tv1.setText("Welcome, "+ttname);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(Activity2.this,com.example.explicitintentapp.MainActivity.class);
                startActivity(in);
            }
        });

    }
}
