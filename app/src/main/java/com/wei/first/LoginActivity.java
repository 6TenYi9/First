package com.wei.first;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class LoginActivity extends AppCompatActivity {

    Button go;
    ImageView mGirl;
    ImageView fondo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        go=findViewById(R.id.ok);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signup(view);
            }
        });

        mGirl=findViewById(R.id.girl);
        fondo=findViewById(R.id.fondos);

        ImageView logo=findViewById(R.id.girl);
        Animation myanim=AnimationUtils.loadAnimation(this,R.anim.fadein);
        logo.startAnimation(myanim);

        ImageView logo2=findViewById(R.id.fondos);
        Animation myanim2=AnimationUtils.loadAnimation(this,R.anim.blink);

        Glide.with(mGirl)
                //.load(R.drawable.girl)
                .load("https://images.unsplash.com/photo-1640343631072-37ff06fd3397?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=764&q=80") //persone
                //.load("https://i.pinimg.com/236x/60/2a/7a/602a7a466b24603a7f7fc69588e84cb3--iphone--wallpaper-phone-wallpapers.jpg")
                //.load("https://wallpaperaccess.com/full/1796653.jpg") //dragon
                .circleCrop()
                .into(mGirl);
        Glide.with(fondo)
                .load("https://images.unsplash.com/photo-1565214975484-3cfa9e56f914?ixlib=rb-1.2.1&ixid=eyJhcHBfaWQiOjEyMDd9&auto=format&fit=crop&w=1482&q=80")
                .transition(DrawableTransitionOptions.withCrossFade(2000))
                .placeholder(new ColorDrawable(this.getResources().getColor(R.color.holder)))
                .centerCrop()
                .into(fondo);
    }
    public void signup(View view){
        Intent intent=new Intent(this,SignupActivity.class);

        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);

        startActivity(intent);


    }
}