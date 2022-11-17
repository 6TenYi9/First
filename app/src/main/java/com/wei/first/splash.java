package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.wei.first.R;

public class splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        openApp();

        ImageView fondo=findViewById(R.id.fondo);
        ImageView logo=findViewById(R.id.logo);

        Animation myanim=AnimationUtils.loadAnimation(this,R.anim.fadein);
        logo.startAnimation(myanim);
        Animation myanim2=AnimationUtils.loadAnimation(this,R.anim.blink);
        fondo.startAnimation(myanim2);

        Glide.with(this)
                .load("https://wallpaperaccess.com/full/1796653.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.spholder)))
                .into(fondo);

    }

    private void openApp(){
        Handler handler=new Handler();
        handler.postDelayed(new Runnable(){
           @Override
           public void run(){
               Intent intent =new Intent(splash.this,LoginActivity.class);
               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
               intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
               startActivity(intent);
           }
        },5000);
    }
}