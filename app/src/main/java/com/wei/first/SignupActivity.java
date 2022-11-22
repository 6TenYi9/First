package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SignupActivity extends AppCompatActivity {

    Button cancel;
    Button next;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        cancel=findViewById(R.id.cancel);
        next=findViewById(R.id.login);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goback(view);
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                toMain();
            }
        });
    }
    public void goback (View view){
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent);
    }

    public void toMain(){
        Intent itent=new Intent(this,Main.class);
        startActivity(itent);
    }
}