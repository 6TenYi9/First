package com.wei.first;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
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

    //dialogo modal
    @SuppressLint("ResourceType")
    public void showAlertDialogButtonClicked(Main mainActivity){
        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);

        /*builder.setTitle("Alerta!!");
        builder.setMessage("se ha exipirado su tiempo de registro, desea continuar?");
        builder.setIcon(R.drawable.dragon);
        builder.setCancelable(false);*/

        builder.setView(getLayoutInflater().inflate(R.layout.alertdialog,null));
        builder.setCancelable(false);

        Button confirmar,cancelar;

        confirmar=findViewById(R.id.co);
        cancelar=findViewById(R.id.ca);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        /*builder.setPositiveButton("confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });*/

        AlertDialog dialog=builder.create();
        dialog.show();
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

    @Override
    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.menu_context,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();

        if (id==R.id.item1){
            //alert dialog
            showAlertDialogButtonClicked(Main.this);


            Toast toast = Toast.makeText(this, "RELOADING...", Toast.LENGTH_LONG);
            toast.show();
            miVisorWeb.reload();
        }
        if (id==R.id.item2){
            final ConstraintLayout mLayout=findViewById(R.id.constLayout);
            Snackbar snackbar=Snackbar
                    .make(mLayout,"Se descargará la imagen en su equipo!",Snackbar.LENGTH_LONG)
                    .setAction("OK", new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Snackbar snackbar1=Snackbar.make(mLayout,"Descargando...",Snackbar.LENGTH_LONG);
                            snackbar1.show();
                            toOther();
                        }
                    });
            snackbar.show();
        }
        return super.onOptionsItemSelected(item);
    }

    public void toOther(){
        Intent itent=new Intent(this,ActivityAppBt.class);
        startActivity(itent);
    }
}