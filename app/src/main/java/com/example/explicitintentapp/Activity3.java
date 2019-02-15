package com.example.explicitintentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Activity3 extends AppCompatActivity {

    EditText et1;
    Button btn1;
    Button btn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        et1=findViewById(R.id.et1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et1.getText().toString().isEmpty()){
                    Toast.makeText(Activity3.this,"plese enter surename",Toast.LENGTH_SHORT).show();
                }
                else{
                    String surename;
                    surename=et1.getText().toString().trim();
                    Intent in=new Intent();
                    in.putExtra("surename",surename);
                    setResult(RESULT_OK,in);
                    Activity3.this.finish();
                }

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setResult(RESULT_CANCELED);
                Activity3.this.finish();
            }
        });


    }
}
