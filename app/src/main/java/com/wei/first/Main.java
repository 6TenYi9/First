package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView vista=(TextView) findViewById(R.id.textview);
        registerForContextMenu(vista);


    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                Toast toast=Toast.makeText(this,"item copiar",Toast.LENGTH_LONG);
                toast.show();
                return true;
            case R.id.item2:
                Toast toast2=Toast.makeText(this,"Dowloading item ...",Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return false;
        }
    }
}