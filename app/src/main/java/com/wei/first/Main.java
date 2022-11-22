package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Main extends AppCompatActivity {

    private SwipeRefreshLayout swipeLayout;
    private WebView miVisorWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) WebView vista = (WebView) findViewById(R.id.textview);
        registerForContextMenu(vista);

        miVisorWeb=(WebView)findViewById(R.id.textview);
        /*miVisorWeb.loadUrl("https://thispersondoesnotexist.com");*/
        miVisorWeb.loadUrl("https://thiscatdoesnotexist.com/");

        swipeLayout = (SwipeRefreshLayout) findViewById(R.id.myswipe);
        swipeLayout.setOnRefreshListener(mOnRefreshListener);
    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo){
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.item1:
                /*Toast toast=Toast.makeText(this,"item copiar",Toast.LENGTH_LONG);
                toast.show();*/

                final ConstraintLayout mLayout=findViewById(R.id.constLayout);
                Snackbar snackbar=Snackbar
                        .make(mLayout,"Se copiará la imagen en portapapeles!",Snackbar.LENGTH_LONG)
                        .setAction("ENTENDIDO", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Snackbar snackbar1=Snackbar.make(mLayout,"Copiado!",Snackbar.LENGTH_LONG);
                                snackbar1.show();
                            }
                        });
                snackbar.show();

                return true;
            case R.id.item2:
                Toast toast2=Toast.makeText(this,"Dowloading item ...",Toast.LENGTH_LONG);
                toast2.show();
                return true;
            default:
                return false;
        }
    }

    protected SwipeRefreshLayout.OnRefreshListener
    mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            Toast toast0 = Toast.makeText(Main.this, "going swipeREFRESH",
                    Toast.LENGTH_LONG);
            toast0.show();
            miVisorWeb.reload();
            swipeLayout.setRefreshing(false);
        }
    };
}