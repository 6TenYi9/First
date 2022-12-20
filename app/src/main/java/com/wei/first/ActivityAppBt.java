package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityAppBt extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_bt);

        BottomAppBar bottomAppBar=findViewById(R.id.bottom_app_bar);
        FloatingActionButton boton=findViewById(R.id.fab);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ActivityAppBt.this,"FAB clicked",Toast.LENGTH_SHORT).show();
            }
        });

    }
}