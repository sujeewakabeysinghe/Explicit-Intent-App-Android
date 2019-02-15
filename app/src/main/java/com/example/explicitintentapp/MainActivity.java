package com.example.explicitintentapp;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button btn1,btn2;
    TextView tv1;
    final int Ac3=0;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==Ac3){
            if(resultCode==RESULT_OK){
                tv1.setText(data.getStringExtra("surename"));
                tv1.setVisibility(View.VISIBLE);
            }
            if(resultCode==RESULT_CANCELED){
                tv1.setText("no surename entered");
                tv1.setVisibility(View.VISIBLE);
            }
        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=findViewById(R.id.et1);
        btn1=findViewById(R.id.btn1);
        btn2=findViewById(R.id.btn2);
        tv1=findViewById(R.id.tv1);

        tv1.setVisibility(View.GONE);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(et1.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this,"nothing included",Toast.LENGTH_SHORT).show();
                }
                else{
                    String tname=et1.getText().toString().trim();
                    Intent in=new Intent(MainActivity.this,com.example.explicitintentapp.Activity2.class);
                    in.putExtra("thisname",tname);
                    startActivity(in);
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in=new Intent(MainActivity.this,com.example.explicitintentapp.Activity3.class);
                startActivityForResult(in,Ac3);
            }
        });



    }
}
